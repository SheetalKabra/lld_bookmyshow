package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Seat extends BaseModel{
    private String seatnumber;
    private int row;
    private int col;
    private SeatType seatType;
}
