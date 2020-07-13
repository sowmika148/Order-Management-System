package com.inventory.orderitemservice.dao;

import com.inventory.orderitemservice.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemDao extends JpaRepository<OrderItem, Integer> {
}
