package id.luannv.e_learning.exception;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ApiException extends RuntimeException {
    ErrorCode errorCode;
    List<FieldErrorResponse> fieldErrorResponses;

    public ApiException(ErrorCode errorCode) {
        this(errorCode, List.of());
    }

    public ApiException(ErrorCode errorCode, List<FieldErrorResponse> fieldErrorResponses) {
        this.errorCode = errorCode;
        this.fieldErrorResponses = fieldErrorResponses;
    }
}
