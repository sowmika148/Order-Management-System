package com.inventory.orderservice.dao;

import com.inventory.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order, Integer> {
}
