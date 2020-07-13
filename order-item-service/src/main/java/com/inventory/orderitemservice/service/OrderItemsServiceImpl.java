package com.inventory.orderitemservice.service;

import com.inventory.orderitemservice.dao.OrderItemDao;
import com.inventory.orderitemservice.model.OrderItem;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderItemsServiceImpl implements OrderItemService {

    private OrderItemDao orderItemDao;

    @Override
    public List<OrderItem> saveOrderItems(List<OrderItem> orderItems) {
        return orderItemDao.saveAll(orderItems);
    }

    @Override
    public OrderItem getOrderItemById(int orderItemId) {
        return orderItemDao.findById(orderItemId).orElse(null);
    }
}
