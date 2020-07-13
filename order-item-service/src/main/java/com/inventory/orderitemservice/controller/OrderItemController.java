package com.inventory.orderitemservice.controller;

import com.inventory.orderitemservice.api.request.OrderItemsRequest;
import com.inventory.orderitemservice.model.OrderItem;
import com.inventory.orderitemservice.service.OrderItemService;
import com.inventory.orderitemservice.api.response.OrderItemsResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/order-item")
public class OrderItemController {

    private OrderItemService orderItemService;

    @PostMapping
    public ResponseEntity<OrderItemsResponse> save(@RequestBody OrderItemsRequest orderItemsRequest) {
        List<OrderItem> orderItems = orderItemService.saveOrderItems(orderItemsRequest.getOrderItems());
        return new ResponseEntity<>(new OrderItemsResponse(orderItems), HttpStatus.CREATED);
    }

    @GetMapping("/{orderItemId}")
    public ResponseEntity<OrderItem> getById(@PathVariable int orderItemId) {
        OrderItem orderItem = orderItemService.getOrderItemById(orderItemId);
        if (orderItem != null)
            return new ResponseEntity<>(orderItem, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
