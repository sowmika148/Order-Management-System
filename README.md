# INVENTORY

2 Services

- Order - Creates order and retrieves orders
  <br>port: 8085
  <br>service name: order-service

- Order Item Service - Creates Order Items and retrieve Order Item
  <br>port: 8086
  <br>service name: order-service

Sample Request for placing an order:

```
{
	"customerName": "Sowmika",
	"orderDate" : "2020-07-10T12:34:56.123456789Z",
	"shippingAddress": "Hyd",
	"total": 2000,
	"orderItems": [
        {
            "productCode": "i1",
            "productName": "item1",
            "quantity": 5
        },
        {
            "productCode": "i2",
            "productName": "Item2",
            "quantity": 2
        }
    ]
}
```

Sample Request for getting an order:

```
http://localhost:8085/order/{orderId}
```

Things yet to be done

- Tests
- API request Validation
- some refactoring
- Error handling needs to be done everywhere(it is done only in one place)
