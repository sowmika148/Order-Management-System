package com.inventory.orderservice.controller;

import com.inventory.orderservice.api.request.OrderRequest;
import com.inventory.orderservice.api.response.OrderResponse;
import com.inventory.orderservice.exception.FailedToCreateOrderException;
import com.inventory.orderservice.exception.OrderNotFoundException;
import com.inventory.orderservice.model.CompleteOrder;
import com.inventory.orderservice.model.Order;
import com.inventory.orderservice.service.OrderService;
import java.util.List;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> save(@Valid @RequestBody OrderRequest orderRequest) {
        CompleteOrder order = orderService.saveOrder(orderRequest);
        if (order == null) {
            throw new FailedToCreateOrderException("Failed to create order");
        }
        OrderResponse response = new OrderResponse();
        BeanUtils.copyProperties(order, response);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable int orderId)
            throws OrderNotFoundException {
        CompleteOrder order = orderService.getOrderById(orderId);
        if (order == null) {
            throw new OrderNotFoundException("Order not found");
        }
        OrderResponse response = new OrderResponse();
        BeanUtils.copyProperties(order, response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
