package com.inventory.orderitemservice.api.request;

import com.inventory.orderitemservice.model.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemsRequest {

    private List<OrderItem> orderItems;
}
