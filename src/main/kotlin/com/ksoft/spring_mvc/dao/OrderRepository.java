package com.ksoft.spring_mvc.dao;

import com.ksoft.spring_mvc.entity.Order;
import com.ksoft.spring_mvc.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
