package com.scaler.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Chair extends BaseModel{
    private String chairnumber;
    private int rowIndex;
    private int colNumber;
    @ManyToOne
    private ChairType chairType;
    /*
        Seat : SeatType
        1 : 1
        m : 1
     */

}
