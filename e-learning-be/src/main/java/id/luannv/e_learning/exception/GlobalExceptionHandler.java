package id.luannv.e_learning.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import id.luannv.e_learning.dto.response.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResponse> uncategoriedException(RuntimeException runtimeException) {
        return ResponseEntity.badRequest().body(ApiResponse.<String, Void, Void>builder()
                .success(false)
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .message(ErrorCode.UNCATEGORIZED_ERROR.getMessage())
                .build());
    }

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiResponse> handleApiException(ApiException ex) {
        ApiResponse response = ApiResponse.builder()
                .success(false)
                .statusCode(ex.getErrorCode().getStatus())
                .message(ex.getMessage())
                .build();
        return ResponseEntity.status(ex.getErrorCode().getStatus()).body(response);
    }
}
