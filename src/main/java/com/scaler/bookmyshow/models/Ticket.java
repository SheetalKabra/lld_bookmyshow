package com.scaler.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel{
    @ManyToOne
    private User bookedBy;
    private int amount;
    private Date timeOfBooking;
    @ManyToMany
    private List<Chair> chairs;
    @ManyToOne
    private Event event;
    //one ticket can have multiple payments.
    //but, one payment will have one ticket
    @OneToMany
    private List<Payment> payments;
    @Enumerated(EnumType.ORDINAL)
    private TicketStatus ticketStatus;
}
