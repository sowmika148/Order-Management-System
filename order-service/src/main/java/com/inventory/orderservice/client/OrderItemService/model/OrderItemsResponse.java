package com.inventory.orderservice.client.OrderItemService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemsResponse {

    private List<OrderItem> orderItems;
}
