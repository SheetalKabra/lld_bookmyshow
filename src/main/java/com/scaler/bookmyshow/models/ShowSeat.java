package com.scaler.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel{

    /*
        ShowSeat : Show
        1 -> 1
        m  <- 1
        one showSeat will have one Show. why? even the class is saying this thing. we don;t have list of shows here.

        for a particular seat,
        for a particular show,
        this is the status

        one showSeat was related to one show only.
        for one show, how many showSeats obj can be there? many
     */
    @ManyToOne
    private Show show;

    /*
        ShowSeat : Seat
        1 -> 1
        m  <- 1
     */
    @ManyToOne
    private Seat seat;
    @Enumerated(EnumType.ORDINAL)
    private SeatStatus seatStatus;
    private Date lockedAt;
}
