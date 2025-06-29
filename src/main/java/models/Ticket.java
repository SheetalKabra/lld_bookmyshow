package models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Ticket extends BaseModel{
    private User bookedBy;
    private int amount;
    private Date timeOfBooking;
    private List<Seat> seats;
    private Show show;
    private List<Payment> payments;
    private TicketStatus ticketStatus;
}
