package com.scaler.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Theater extends BaseModel{
    private String name;
    private String address;
    @OneToMany
    private List<Auditorium> auditoriums;
    @ManyToOne
    private City city;

}
