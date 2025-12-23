package id.luannv.e_learning.controller;

import java.time.Instant;
import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.luannv.e_learning.dto.request.UserCreationRequest;
import id.luannv.e_learning.dto.response.ApiResponse;
import id.luannv.e_learning.dto.response.UserResponse;
import id.luannv.e_learning.exception.ApiException;
import id.luannv.e_learning.exception.ErrorCode;
import jakarta.validation.Valid;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class AuthenticationController {

    @GetMapping("/register")
    public ResponseEntity<ApiResponse> register() {
        log.error(LocalDateTime.now().toString());  
        throw new ApiException(ErrorCode.ALREADY_ENROLLED);
    }
}
