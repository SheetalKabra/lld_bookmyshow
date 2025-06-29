package models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Theater extends BaseModel{
    private String name;
    private String address;
    private List<Auditorium> auditoriums;
    private City city;

}
