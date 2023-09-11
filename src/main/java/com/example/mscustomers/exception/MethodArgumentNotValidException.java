package com.example.mscustomers.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MethodArgumentNotValidException extends Exception{
    public MethodArgumentNotValidException(String message) {
        super(message);
    }
}
