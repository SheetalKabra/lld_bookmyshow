package com.scaler.bookmyshow.controllers;

import com.scaler.bookmyshow.dtos.BookTicketRequestDto;
import com.scaler.bookmyshow.dtos.BookTicketResponseDto;
import com.scaler.bookmyshow.models.Ticket;
import com.scaler.bookmyshow.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TicketController {
    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public BookTicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequestDto) throws Exception {
        ticketService.bookTicket(bookTicketRequestDto.getSeatIds(), bookTicketRequestDto.getShowId(), bookTicketRequestDto.getUserId());
        return null;

    }
}
