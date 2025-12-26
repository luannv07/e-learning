package id.luannv.e_learning.utility;

import id.luannv.e_learning.exception.ApiException;
import id.luannv.e_learning.exception.ErrorCode;
import id.luannv.e_learning.exception.FieldErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;
@Slf4j
public class ValidationErrorCollector {

    public static List<FieldErrorResponse> addBindingErrors(BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) return new ArrayList<>();

        return bindingResult.getFieldErrors()
                .stream()
                .map(fieldError ->
                        {
                            log.error("{} | {}", fieldError.getField(), fieldError.getDefaultMessage());

                            return new FieldErrorResponse(
                                    fieldError.getField(),
                                    fieldError.getDefaultMessage()
                            );
                        }
                ).toList();
    }

    public static void addError(List<FieldErrorResponse> errors, FieldErrorResponse field) {
        errors.add(field);
    }

    public static void throwIfHasErrors(List<FieldErrorResponse> errors) {
        if (!errors.isEmpty()) {
            throw new ApiException(ErrorCode.INVALID_PARAM, errors);
        }
    }
}
