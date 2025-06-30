package com.scaler.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookTicketResponseDto {
    private int amount;
    private Long ticketId;
    private List<String> seatnumber;
    private String auditoriumName;
}


//payment link is hardcoded like : bookmyshow.com/pay/{ticketId}