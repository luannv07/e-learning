package id.luannv.e_learning.dto.request;
import jakarta.validation.constraints.Email;
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
public class UserCreationRequest {
    @Pattern(message = "USERNAME_INVALID", regexp = "^[a-z][a-z0-9]{3,}$")
	@NotBlank(message = "FIELD_BLANK")
    @Max(value = 50, message = "FIELD_TOO_LONG")
	String username;
	@Pattern(message = "PASSWORD_INVALID", regexp = "^.{3,}$")
	@NotBlank(message = "FIELD_BLANK")
    @Max(value = 50, message = "FIELD_TOO_LONG")
	String password;
	@Email(regexp = "^[a-zA-Z0-9._%+-]+@gmail\\.com$", message = "EMAIL_INVALID")
    @Max(value = 50, message = "FIELD_TOO_LONG")
	@NotBlank(message = "FIELD_BLANK")
	String email;
    @Max(value = 255, message = "FIELD_TOO_LONG")
	String address;
    @NotBlank(message = "FIELD_BLANK")
    @Max(value = 50, message = "FIELD_TOO_LONG")
    String firstName;
    @NotBlank(message = "FIELD_BLANK")
    @Max(value = 50, message = "FIELD_TOO_LONG")
    String lastName;
}
