package com.ksoft.spring_mvc.controllers;

import com.ksoft.spring_mvc.dao.BookingRepository;
import com.ksoft.spring_mvc.dao.OrderRepository;
import com.ksoft.spring_mvc.dao.ServiceRepository;
import com.ksoft.spring_mvc.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/orders/{bookingId}")
    public List<Order> getOrders(@RequestParam("bookingId") String bookingId) {
        return orderRepository.findByBookingId(bookingId);
    }
}
