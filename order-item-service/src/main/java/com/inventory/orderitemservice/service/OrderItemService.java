package com.inventory.orderitemservice.service;

import com.inventory.orderitemservice.model.OrderItem;

import java.util.List;

public interface OrderItemService {

    public List<OrderItem> saveOrderItems(List<OrderItem> orderItems);
    public OrderItem getOrderItemById(int orderItemId);
}
