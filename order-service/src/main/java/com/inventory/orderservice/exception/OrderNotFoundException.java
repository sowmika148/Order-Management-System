package com.inventory.orderservice.exception;

public class OrderNotFoundException extends Exception {

    public OrderNotFoundException(String msg) {
        super(msg);
    }
}
