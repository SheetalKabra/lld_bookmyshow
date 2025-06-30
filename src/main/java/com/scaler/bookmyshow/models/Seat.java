package com.scaler.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="chair")
public class Seat extends BaseModel{
    private String seatno;
    private int rowIndex;
    private int colNumber;
    @ManyToOne
    private SeatType seatType;
    /*
        Seat : SeatType
        1 : 1
        m : 1
     */

}
