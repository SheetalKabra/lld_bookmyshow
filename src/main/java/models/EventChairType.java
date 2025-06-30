package models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class EventChairType extends BaseModel{
    @ManyToOne
    private Event event;
    @ManyToOne
    private ChairType chairType;
    private int price;
}
