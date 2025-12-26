package id.luannv.e_learning.exception;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FieldErrorResponse {
    String field;
    String message;
}
