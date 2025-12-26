package id.luannv.e_learning.service.impl;

import id.luannv.e_learning.dto.request.UserCreationRequest;
import id.luannv.e_learning.dto.request.UserLoginRequest;
import id.luannv.e_learning.dto.response.UserResponse;
import id.luannv.e_learning.entity.User;
import id.luannv.e_learning.exception.ApiException;
import id.luannv.e_learning.exception.ErrorCode;
import id.luannv.e_learning.exception.FieldErrorResponse;
import id.luannv.e_learning.mapper.UserMapper;
import id.luannv.e_learning.repository.UserRepository;
import id.luannv.e_learning.service.AuthenticationService;
import id.luannv.e_learning.utility.ValidationErrorCollector;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    UserRepository userRepository;
    UserMapper  userMapper;
    PasswordEncoder passwordEncoder;

    @Override
    public UserResponse register(UserCreationRequest userCreationRequest, BindingResult bindingResult) {
        List<FieldErrorResponse> fieldErrorResponses = ValidationErrorCollector.addBindingErrors(bindingResult);

        if (userRepository.existsByUsername(userCreationRequest.getUsername())) {
            log.error("Username '{}' already exists", userCreationRequest.getUsername());
            ValidationErrorCollector
                    .addError(fieldErrorResponses, new FieldErrorResponse("username", ErrorCode.USER_ALREADY_EXISTS.getMessage()));
        }
        if (userRepository.existsByEmail(userCreationRequest.getEmail())) {
            log.error("Email '{}' already exists", userCreationRequest.getEmail());
            ValidationErrorCollector
                    .addError(fieldErrorResponses, new FieldErrorResponse("email", ErrorCode.USER_ALREADY_EXISTS.getMessage()));
        }

        ValidationErrorCollector.throwIfHasErrors(fieldErrorResponses);

        User entity = userMapper.toEntity(userCreationRequest);
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));

        User savedUser = userRepository.save(entity);
        return userMapper.toResponse(savedUser);
    }

    @Override
    public UserResponse login(UserLoginRequest userLoginRequest,  BindingResult bindingResult) {
        List<FieldErrorResponse> fieldErrorResponses = ValidationErrorCollector.addBindingErrors(bindingResult);

        ValidationErrorCollector.throwIfHasErrors(fieldErrorResponses);

        User user = userRepository.findByUsername(userLoginRequest.getUsername())
                .orElseThrow(() -> new ApiException(ErrorCode.LOGIN_FAILED));
        if (!passwordEncoder.matches(userLoginRequest.getPassword(), user.getPassword()))
            throw new ApiException(ErrorCode.LOGIN_FAILED);

        return userMapper.toResponse(user);
    }
}
