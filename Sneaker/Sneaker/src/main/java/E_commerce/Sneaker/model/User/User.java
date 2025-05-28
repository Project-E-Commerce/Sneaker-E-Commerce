package E_commerce.Sneaker.model.User;


import E_commerce.Sneaker.model.Order.Order;
import E_commerce.Sneaker.model.Role.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user")
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id", nullable = false)
    private Long userId;

    @Column(name="username", unique = true, nullable = false, columnDefinition = "VARCHAR(255) COLLATE utf8mb4_unicode_ci")
    private String username;
    private String password;
    private String email;
    private Date created_at;
    private String phone;
    private String address;
    private boolean gender;

    @ManyToMany
    Set<Role> roles;

    @OneToMany
    List<Order> orders;
}
