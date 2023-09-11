package com.example.mscustomers.exception.handler;

import com.example.mscustomers.exception.MethodArgumentNotValidException;
import com.example.mscustomers.exception.OrderCancellationException;
import com.example.mscustomers.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDto> handleResourceNotFoundException(ResourceNotFoundException e) {
        String[] message = {e.getMessage()};
        ErrorResponse errorResponse = new ErrorResponse(message, true);
        ErrorDto errorDto = new ErrorDto(errorResponse, HttpStatus.NOT_FOUND.value(), false);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDto);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String[] message = {e.getMessage()};
        ErrorResponse errorResponse = new ErrorResponse(message, true);
        ErrorDto errorDto = new ErrorDto(errorResponse,HttpStatus.BAD_REQUEST.value(),false);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDto);
    }

    @ExceptionHandler(OrderCancellationException.class)
    public ResponseEntity<ErrorDto> handleOrderCancellation(MethodArgumentNotValidException e) {
        String[] message = {e.getMessage()};
        ErrorResponse errorResponse = new ErrorResponse(message, true);
        ErrorDto errorDto = new ErrorDto(errorResponse,HttpStatus.BAD_REQUEST.value(),false);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDto);
    }
}
