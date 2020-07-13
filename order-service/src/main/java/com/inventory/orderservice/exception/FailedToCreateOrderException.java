package com.inventory.orderservice.exception;

public class FailedToCreateOrderException extends RuntimeException {

    public FailedToCreateOrderException(String message) {
        super(message);
    }
}
