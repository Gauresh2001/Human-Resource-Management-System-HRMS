package com.hrms.exception;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Resource Not Found Exception
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleResourceNotFoundException(
            ResourceNotFoundException ex,
            HttpServletRequest request) {

        ApiError error = new ApiError(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                "NOT_FOUND",
                ex.getMessage(),
                request.getRequestURI());

        return new ResponseEntity<>(
                error,
                HttpStatus.NOT_FOUND);
    }

    // Duplicate Resource Exception
    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ApiError> handleDuplicateResourceException(
            DuplicateResourceException ex,
            HttpServletRequest request) {

        ApiError error = new ApiError(
                LocalDateTime.now(),
                HttpStatus.CONFLICT.value(),
                "CONFLICT",
                ex.getMessage(),
                request.getRequestURI());

        return new ResponseEntity<>(
                error,
                HttpStatus.CONFLICT);
    }

    // Unauthorized Exception
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ApiError> handleUnauthorizedException(
            UnauthorizedException ex,
            HttpServletRequest request) {

        ApiError error = new ApiError(
                LocalDateTime.now(),
                HttpStatus.UNAUTHORIZED.value(),
                "UNAUTHORIZED",
                ex.getMessage(),
                request.getRequestURI());

        return new ResponseEntity<>(
                error,
                HttpStatus.UNAUTHORIZED);
    }

    // Invalid Credentials Exception
    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<ApiError> handleInvalidCredentialsException(
            InvalidCredentialsException ex,
            HttpServletRequest request) {

        ApiError error = new ApiError(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "BAD_REQUEST",
                ex.getMessage(),
                request.getRequestURI());

        return new ResponseEntity<>(
                error,
                HttpStatus.BAD_REQUEST);
    }

    // Validation Exception
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>>
    handleValidationException(
            MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult()
                .getAllErrors()
                .forEach(error -> {

                    String fieldName =
                            ((FieldError) error)
                                    .getField();

                    String message =
                            error.getDefaultMessage();

                    errors.put(fieldName, message);
                });

        return new ResponseEntity<>(
                errors,
                HttpStatus.BAD_REQUEST);
    }

    // Global Exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGlobalException(
            Exception ex,
            HttpServletRequest request) {

        ApiError error = new ApiError(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "INTERNAL_SERVER_ERROR",
                ex.getMessage(),
                request.getRequestURI());

        return new ResponseEntity<>(
                error,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
