package com.ksoft.spring_mvc.dao;

import com.ksoft.spring_mvc.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByCheckOutTimeIsNull();
    List<Booking> findByCheckOutTimeIsNotNull();
}
