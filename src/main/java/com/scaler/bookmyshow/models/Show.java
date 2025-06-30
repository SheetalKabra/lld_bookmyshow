package com.scaler.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@Entity
@Table(name="event")
public class Show extends BaseModel{
    /*
        Show : Audi
        1 -> 1
        m  <- 1
     */
    @ManyToOne
    private Auditorium auditorium;
    private Date startTime;
    private Date endTime;
    /*
        Show : Movie
        1 -> 1
        m  <- 1
        One show will be of how many movies? 1 -> 1
        for one movie, how many shows can be running? 1 -> m
     */
    @ManyToOne
    private Movie movie;
    @Enumerated(EnumType.ORDINAL)
    private Language language;
}
