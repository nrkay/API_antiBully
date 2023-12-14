package com.example.antiBully.advice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@AllArgsConstructor
public class ValidationCustomeError {
    private final HttpStatus httpStatus;
    private final List<String> problem;
}
