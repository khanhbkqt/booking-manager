package com.ksoft.spring_mvc.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class NewOrderRequestData {
    private Long bookingId;
    private Long serviceId;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date date;
    private int quantity;
}
