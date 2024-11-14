package com.example.demo.run;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RunNotFoundExeption extends RuntimeException {
    public RunNotFoundExeption() {
        super("Run not found");
    }
}
