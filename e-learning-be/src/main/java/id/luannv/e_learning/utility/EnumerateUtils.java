package id.luannv.e_learning.utility;

import id.luannv.e_learning.exception.ErrorCode;
import id.luannv.e_learning.exception.FieldErrorResponse;

public class EnumerateUtils {
    public static FieldErrorResponse convertFieldMessageToMessage(FieldErrorResponse fieldErrorResponse) {
        String field =  fieldErrorResponse.getField();
        StringBuilder errorMessageBuilder = new StringBuilder();

        try {
            String converted = ErrorCode.valueOf(fieldErrorResponse.getMessage())
                    .getMessage();

            errorMessageBuilder.append(converted);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return FieldErrorResponse.builder()
                .field(field)
                .message(errorMessageBuilder.toString())
                .build();
    }
}
