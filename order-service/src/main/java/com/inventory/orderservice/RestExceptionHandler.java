package com.inventory.orderservice;

import com.inventory.orderservice.api.error.ApiError;
import com.inventory.orderservice.exception.FailedToCreateOrderException;
import com.inventory.orderservice.exception.OrderNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = OrderNotFoundException.class)
    protected ResponseEntity<Object> handleOrderNotFound(OrderNotFoundException ex,
            WebRequest request) {
        ApiError apiError = new ApiError(HttpStatus.NO_CONTENT, ex.getMessage());
        return handleExceptionInternal(ex, apiError, new HttpHeaders(), HttpStatus.NO_CONTENT,
                request);
    }

    @ExceptionHandler(value = FailedToCreateOrderException.class)
    protected ResponseEntity<Object> handleFailedToCreateOrder(FailedToCreateOrderException ex,
            WebRequest request) {
        ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return handleExceptionInternal(ex, apiError, new HttpHeaders(),
                HttpStatus.INTERNAL_SERVER_ERROR, request);
    }


    /*@ExceptionHandler(value = MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status, WebRequest request) {

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, errors.toString());

        return handleExceptionInternal(ex, apiError, new HttpHeaders(),
                HttpStatus.BAD_REQUEST, request);
    }*/
}
