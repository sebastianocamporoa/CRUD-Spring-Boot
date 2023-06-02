package com.globalhitss.PruebaTecnica.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.dao.DataIntegrityViolationException;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class ApiError {
    private String timestamp;
    private int status;
    private String error;
    private String message;

    public ApiError(int status, DataIntegrityViolationException error, String message) {
        this.timestamp = LocalDateTime.now().toString();
        this.status = status;
        this.error = error.getMessage();
        this.message = message;
    }


}
