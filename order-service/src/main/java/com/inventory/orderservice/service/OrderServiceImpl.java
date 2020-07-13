package com.inventory.orderservice.service;

import com.inventory.orderservice.api.request.OrderRequest;
import com.inventory.orderservice.client.OrderItemService.OrderItemClient;
import com.inventory.orderservice.client.OrderItemService.model.OrderItem;
import com.inventory.orderservice.client.OrderItemService.model.OrderItemsRequest;
import com.inventory.orderservice.client.OrderItemService.model.OrderItemsResponse;
import com.inventory.orderservice.dao.OrderDao;
import com.inventory.orderservice.model.CompleteOrder;
import com.inventory.orderservice.model.Order;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao;

    private OrderItemClient orderItemClient;

    @Override
    public CompleteOrder saveOrder(OrderRequest orderRequest) {
        List<OrderItem> orderItems = orderRequest.getOrderItems();
        OrderItemsRequest request = new OrderItemsRequest(orderItems);
        List<Integer> orderItemIds = saveOrderItems(request);
        if (orderItemIds == null) {
            return null;
        }
        Order order = mapOrderRequestToOrder(orderRequest, orderItemIds);
        return mapOrderToCompleteOrder(orderDao.save(order), orderItems);
    }

    private List<Integer> saveOrderItems(OrderItemsRequest request) {
        ResponseEntity response = orderItemClient.save(request);
        if (response.getStatusCode() == HttpStatus.CREATED) {
            OrderItemsResponse orderItemsResponse = (OrderItemsResponse) response.getBody();
            //TODO CHeck if response is null and throw valid exception
            List<OrderItem> orderItems = orderItemsResponse.getOrderItems();
            return orderItems.stream()
                    .map(OrderItem::getId).collect(Collectors.toList());
        }
        return null;
    }


    // TODO Can be moved to Utils
    private Order mapOrderRequestToOrder(OrderRequest orderRequest, List<Integer> orderItemIds) {
        return Order.builder()
                .customerName(orderRequest.getCustomerName())
                .orderDate(orderRequest.getOrderDate())
                .shippingAddress(orderRequest.getShippingAddress())
                .orderItems(orderItemIds)
                .total(orderRequest.getTotal())
                .build();
    }

    @Override
    public CompleteOrder getOrderById(int orderId) {
        Order order = orderDao.findById(orderId).orElse(null);
        if (order == null) {
            return null;
        }
        List<OrderItem> orderItems = new ArrayList<>();
        order.getOrderItems()
                .forEach(itemId -> {
                    ResponseEntity response = orderItemClient.getById(itemId);
                    if (response.getStatusCode() == HttpStatus.OK) {
                        OrderItem orderItem = (OrderItem) response.getBody();
                        orderItems.add(orderItem);
                    }
                });
        return mapOrderToCompleteOrder(order, orderItems);

    }

    // TODO Can be moved to Utils
    private CompleteOrder mapOrderToCompleteOrder(Order order, List<OrderItem> orderItems) {
        if (order == null) {
            return null;
        }
        return CompleteOrder.builder()
                .customerName(order.getCustomerName())
                .orderDate(order.getOrderDate())
                .orderItems(orderItems)
                .shippingAddress(order.getShippingAddress())
                .total(order.getTotal())
                .build();
    }


}
