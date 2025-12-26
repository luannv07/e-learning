package id.luannv.e_learning.dto.response;

import id.luannv.e_learning.entity.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    String username;
    String firstName;
    String lastName;
    String email;
    String address;
    String avatarLink;
    Set<Role> roles;
}
