package com.lcwd.user.service.exceptions;


import com.lcwd.user.service.payload.ApiRespone;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiRespone> handleResourceNotFoundException(ResourceNotFoundException ex)
    {
        String message = ex.getMessage();
        ApiRespone build = ApiRespone.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
    return new ResponseEntity<ApiRespone>(build,HttpStatus.NOT_FOUND);
    }



}
