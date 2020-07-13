package com.inventory.orderservice.service;

import com.inventory.orderservice.api.request.OrderRequest;
import com.inventory.orderservice.model.CompleteOrder;
import com.inventory.orderservice.model.Order;

public interface OrderService {

    CompleteOrder saveOrder(OrderRequest orderRequest);
    CompleteOrder getOrderById(int orderId);
}
