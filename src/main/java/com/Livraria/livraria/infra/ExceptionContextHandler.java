package com.Livraria.livraria.infra;

import com.Livraria.livraria.exceptions.BookNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionContextHandler {

    @ExceptionHandler(BookNotFound.class)
    public ResponseEntity<String> bookNotFound(BookNotFound bookNotFound) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("book not found: " + bookNotFound.getMessage());
    }
}
