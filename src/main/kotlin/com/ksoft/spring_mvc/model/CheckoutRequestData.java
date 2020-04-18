package com.ksoft.spring_mvc.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class CheckoutRequestData {
    private Long bookingId;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date checkoutTime;
}
