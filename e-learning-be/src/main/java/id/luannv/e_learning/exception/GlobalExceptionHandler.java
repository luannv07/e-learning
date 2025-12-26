package id.luannv.e_learning.exception;

import id.luannv.e_learning.utility.EnumerateUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import id.luannv.e_learning.dto.response.ApiResponse;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@Log4j2
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> uncategorizedException(Exception e) {
        log.error(e.getMessage(), e);
        return ResponseEntity.internalServerError().body(ApiResponse.<String, Void, Void>builder()
                .success(false)
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(ErrorCode.UNCATEGORIZED_ERROR.getMessage())
                .build());
    }

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<?> handleApiException(ApiException ex) {
        ErrorCode errorCode = ex.getErrorCode();
        List<FieldErrorResponse> fieldErrorResponses = ex.getFieldErrorResponses()
                .stream()
                .map(EnumerateUtils::convertFieldMessageToMessage)
                .toList();

        return ResponseEntity.badRequest().body(ApiResponse.builder()
                .success(false)
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .errors(fieldErrorResponses)
                .message(errorCode.getMessage())
                .build());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        var messages = ex.getBindingResult().getFieldErrors();

        messages.forEach((fieldError) -> log.info("manve: {} {}", fieldError.getField(), fieldError.getDefaultMessage()));

        return null;
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<?> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
        return ResponseEntity.status(ErrorCode.METHOD_NOT_ALLOWED.getStatus()).body(
                ApiResponse.builder()
                        .success(false)
                        .statusCode(ErrorCode.METHOD_NOT_ALLOWED.getStatus())
                        .message(ErrorCode.METHOD_NOT_ALLOWED.getMessage())
                        .build()
        );
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        return ResponseEntity.status(ErrorCode.FORM_BODY_MISSING.getStatus()).body(
                ApiResponse.builder()
                        .success(false)
                        .statusCode(ErrorCode.FORM_BODY_MISSING.getStatus())
                        .message(ErrorCode.FORM_BODY_MISSING.getMessage())
                        .build()
        );
    }
}
