package id.luannv.e_learning.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    
    @Column(name = "id", nullable = false, unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "username", nullable = false, length = 50, unique = true)
    String username;
    @Column(name = "password", nullable = false)
    String password;
    @Column(name = "first_name", nullable = false, length = 50)
    String firstName;
    @Column(name = "last_name", nullable = false, length = 50)
    String lastName;
    @Column(name = "email", nullable = false, length = 50, unique = true)
    String email;
    @Column(name = "deleted", nullable = false, columnDefinition = "tinyint default 0")
    boolean deleted;
    @Column(name = "address", length = 255)
    String address;
    @Column(name = "avatar_link")
    String avatarLink;
    @ManyToMany(fetch = FetchType.LAZY)
    Set<Role> roles;
}
