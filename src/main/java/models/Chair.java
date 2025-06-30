package models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Chair extends BaseModel{
    private String chairnumber;
    private int rows;
    private int cols;
    @ManyToOne
    private ChairType chairType;
    /*
        Seat : SeatType
        1 : 1
        m : 1
     */

}
