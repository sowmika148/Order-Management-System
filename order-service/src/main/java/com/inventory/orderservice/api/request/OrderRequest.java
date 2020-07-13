package com.inventory.orderservice.api.request;

import com.inventory.orderservice.client.OrderItemService.model.OrderItem;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    @NotEmpty(message = "Please provide a name")
    private String customerName;
    private Date orderDate;
    private String shippingAddress;
    private List<OrderItem> orderItems;
    private Double total;
}
