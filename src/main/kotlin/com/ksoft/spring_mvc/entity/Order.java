package com.ksoft.spring_mvc.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Order {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bookingId")
    private Booking booking;

    private Date time;

    @ManyToOne
    @JoinColumn(name = "serviceId")
    private Service service;

    private int quantity;

    public Order() {

    }

    public Order(Booking booking, Date time, Service service, int quantity) {
        this.booking = booking;
        this.time = time;
        this.service = service;
        this.quantity = quantity;
    }
}
