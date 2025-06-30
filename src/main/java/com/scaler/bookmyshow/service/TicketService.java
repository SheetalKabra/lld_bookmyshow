package com.scaler.bookmyshow.service;

import com.scaler.bookmyshow.exceptions.InvalidArgumentException;
import com.scaler.bookmyshow.exceptions.SeatNotAvailableException;
import com.scaler.bookmyshow.models.*;
import com.scaler.bookmyshow.repositories.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    private final SeatRepository seatRepository;
    private final ShowRepository showRepository;
    private final ShowSeatRepository showSeatRepository;
    private final UserRepository userRepository;
    private final TicketRepository ticketRepository;

    public TicketService(SeatRepository seatRepository, ShowRepository showRepository, ShowSeatRepository showSeatRepository, UserRepository userRepository, TicketRepository ticketRepository) {
        this.seatRepository = seatRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;
    }

    public Ticket bookTicket(List<Long> seatIds, Long showId, Long userId) throws Exception {
        // 1. for these seatsIds get the corresponding showSeats getSeatsForIDs(seatIds);
        // 2. Check the status of all showseats getShowSeatsForSeats(seats);
        // 2.a. if all seats are available,
        // 3.a lock every seat (set the seat status to be locked)
        // 3.b create ticket object and return it
        // 2.b if some of the seats are not available
        // 3.a throw exception

        List<Seat> seats = seatRepository.findAllById(seatIds);
        Optional<Show> showOptional = showRepository.findById(showId);
        if(showOptional.isEmpty()){
            throw new InvalidArgumentException("Show by: "+showId +" doesn't exists.");
        }
        List<ShowSeat> showSeats = showSeatRepository.findAllBySeatIdInAndShow(seats, showOptional.get());
        //check, if all the seats are available or not
        for(ShowSeat showSeat : showSeats){
            if(!showSeat.getSeatStatus().equals(SeatStatus.AVAILABE)){
                throw new SeatNotAvailableException("Some seats are not available.");
            }
        }
        //meaning all seats are available, so do lock all the seats
        List<ShowSeat> savedShowSeats = new ArrayList<>();
        for(ShowSeat showSeat : showSeats){
            showSeat.setSeatStatus(SeatStatus.LOCKED);
            showSeat.setLockedAt(new Date());
            savedShowSeats.add(showSeatRepository.save(showSeat));
        }

        //now create a ticket
        Ticket ticket = new Ticket();
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()){
            throw new Exception("User not found with user Id: "+ userId);
        }
        ticket.setBookedBy(userOptional.get());
        ticket.setTimeOfBooking(new Date());
        ticket.setTicketStatus(TicketStatus.PROCESSING);
        ticket.setShow(showOptional.get());
        ticket.setSeats(seats);
        ticket.setAmount(0);
        Ticket savedTicket = ticketRepository.save(ticket);
        return savedTicket;
    }
}
