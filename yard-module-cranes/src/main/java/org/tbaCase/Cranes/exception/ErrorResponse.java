package org.tbaCase.Cranes.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Data
public class ErrorResponse {

    private Instant timestamp;
    private HttpStatus errorCode;
    private String message;
    private String status;

    public ErrorResponse() {
        this.timestamp = Instant.now();
    }

    public ErrorResponse(HttpStatus errorCode, String message) {
        this();
        this.errorCode = errorCode;
        this.message = message;
    }

    public ErrorResponse(HttpStatus errorCode, String message, String status) {
        this(errorCode, message);
        this.status = status;
    }

}
