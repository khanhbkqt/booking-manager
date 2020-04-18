package com.ksoft.spring_mvc.controllers;

import com.ksoft.spring_mvc.dao.BookingRepository;
import com.ksoft.spring_mvc.dao.OrderRepository;
import com.ksoft.spring_mvc.dao.ServiceRepository;
import com.ksoft.spring_mvc.entity.Booking;
import com.ksoft.spring_mvc.entity.Order;
import com.ksoft.spring_mvc.entity.Service;
import com.ksoft.spring_mvc.model.ApiResponse;
import com.ksoft.spring_mvc.model.NewOrderRequestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {
    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/orders")
    public List<Order> getOrders(@RequestParam("bookingId") String bookingId) {
        return orderRepository.findByBookingId(bookingId);
    }

    @PostMapping("/orders/new")
    public ApiResponse newOrder(@RequestBody NewOrderRequestData data) {

        if (data.getQuantity() <= 0) {
            return ApiResponse.failed("Số lương phải lớn hơn 0");
        }

        Optional<Service> service = serviceRepository.findById(data.getServiceId());
        if (!service.isPresent()) {
            return ApiResponse.failed("Không tìm thấy dịch vụ có id " + data.getServiceId());
        }
        Optional<Booking> booking = bookingRepository.findById(data.getBookingId());
        if (!booking.isPresent()) {
            return ApiResponse.failed("Không tìm thấy booking có id " + data.getBookingId());
        }

        Order order = new Order(booking.get(), data.getDate(), service.get(), data.getQuantity());
        orderRepository.save(order);

        return ApiResponse.success("Đã tạo thành công order");
    }
}
