package com.inventory.orderservice.client.OrderItemService;

import com.inventory.orderservice.client.OrderItemService.model.OrderItem;
import com.inventory.orderservice.client.OrderItemService.model.OrderItemsRequest;
import com.inventory.orderservice.client.OrderItemService.model.OrderItemsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "order-item-service", url = "http://localhost:8084/order-item")
public interface OrderItemClient {

  @PostMapping
  public ResponseEntity<OrderItemsResponse> save(@RequestBody OrderItemsRequest orderItemsRequest);

  @GetMapping("/{orderItemId}")
  public ResponseEntity<OrderItem> getById(@PathVariable int orderItemId);
}
