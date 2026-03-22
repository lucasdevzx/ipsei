package com.project.ipsei.Resources.exceptions;

import com.project.ipsei.Services.exceptions.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionStandart> userNotFoundException(NotFoundException ex, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        String error = "Not found";
        ExceptionStandart exception = new ExceptionStandart(
                Instant.now(),
                status.value(),
                error,
                ex.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(exception);
    }

    @ExceptionHandler(ConflicException.class)
    public ResponseEntity<ExceptionStandart> conflictException(ConflicException ex, HttpServletRequest request) {
        HttpStatus status = HttpStatus.CONFLICT;
        String error = "Conflict";
        ExceptionStandart exception = new ExceptionStandart(
                Instant.now(),
                status.value(),
                error,
                ex.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(exception);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ExceptionStandart> businessException(BusinessException ex, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String error = "Business exception";
        ExceptionStandart exception = new ExceptionStandart(
                Instant.now(),
                status.value(),
                error,
                ex.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(exception);
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<ExceptionStandart> forbiddenException(ForbiddenException ex, HttpServletRequest request) {
        HttpStatus status = HttpStatus.FORBIDDEN;
        String error = "Forbidden";
        ExceptionStandart exception = new ExceptionStandart(
                Instant.now(),
                status.value(),
                error,
                ex.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(exception);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ExceptionStandart> validationException(ValidationException ex, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String error = "Validation exception";
        ExceptionStandart exception = new ExceptionStandart(
                Instant.now(),
                status.value(),
                error,
                ex.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(exception);
    }
}