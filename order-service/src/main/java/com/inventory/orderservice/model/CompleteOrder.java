package com.inventory.orderservice.model;

import com.inventory.orderservice.client.OrderItemService.model.OrderItem;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompleteOrder {

  private String customerName;
  private Date orderDate;
  private String shippingAddress;
  private List<OrderItem> orderItems;
  private Double total;
}
