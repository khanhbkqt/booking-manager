package com.ksoft.spring_mvc.controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class BookingRequestData {
    private Long roomId;
    private String customerName;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date checkInTime;
    private int numOfGuesses;
}