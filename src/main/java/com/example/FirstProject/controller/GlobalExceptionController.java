package com.example.FirstProject.controller;

import com.example.FirstProject.exception.ErrorResponse;
import com.example.FirstProject.exception.PlayerNotFoundException;
import com.example.FirstProject.exception.StudentNotFoundException;
import com.example.FirstProject.model.Player;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Optional;

@RestControllerAdvice
@Component
public class GlobalExceptionController {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<?> studentNotFound(StudentNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), e.getMessage(), "Student not found");
        return  new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PlayerNotFoundException.class)
    public ResponseEntity<?> playerNotFound(PlayerNotFoundException e){
        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), e.getMessage(), "Player not found");
        return  new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
