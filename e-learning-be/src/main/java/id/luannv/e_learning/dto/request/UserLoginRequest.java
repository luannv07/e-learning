package id.luannv.e_learning.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserLoginRequest {
    @Pattern(message = "USERNAME_INVALID", regexp = "^[a-z][a-z0-9]{3,}$")
    @NotBlank(message = "FIELD_BLANK")
    String username;
    @Pattern(message = "PASSWORD_INVALID", regexp = "^.{3,}$")
    @NotBlank(message = "FIELD_BLANK")
    String password;
}
