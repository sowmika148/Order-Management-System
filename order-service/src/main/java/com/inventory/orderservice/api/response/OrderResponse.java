package com.inventory.orderservice.api.response;

import com.inventory.orderservice.client.OrderItemService.model.OrderItem;
import com.inventory.orderservice.model.CompleteOrder;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse {

    private String customerName;
    private Date orderDate;
    private String shippingAddress;
    private List<OrderItem> orderItems;
    private Double total;
}
