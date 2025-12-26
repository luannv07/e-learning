package id.luannv.e_learning.controller;

import java.time.Instant;
import java.time.LocalDateTime;

import id.luannv.e_learning.dto.request.UserLoginRequest;
import id.luannv.e_learning.service.AuthenticationService;
import id.luannv.e_learning.utility.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody UserCreationRequest userCreationRequest, BindingResult bindingResult) {
        UserResponse userRegistered = authenticationService.register(userCreationRequest, bindingResult);

        return ResponseEntity.ok(ApiResponse.builder()
                .success(true)
                .statusCode(HttpStatus.OK.value())
                .message("Register successful!")
                .data(userRegistered)
                .build());
    }

    @PostMapping("/login")
    public ResponseEntity<?> register(@Valid @RequestBody UserLoginRequest request, BindingResult bindingResult) {
        UserResponse userRegistered = authenticationService.login(request, bindingResult);

        return ResponseEntity.ok(ApiResponse.builder()
                .success(true)
                .statusCode(HttpStatus.OK.value())
                .message("Register successful!")
                .data(userRegistered)
                .build());
    }
}
