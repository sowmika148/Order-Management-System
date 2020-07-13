package com.inventory.orderitemservice.api.response;

import com.inventory.orderitemservice.model.OrderItem;
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
