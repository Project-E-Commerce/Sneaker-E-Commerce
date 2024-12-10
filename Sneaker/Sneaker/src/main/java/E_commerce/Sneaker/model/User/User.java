package E_commerce.Sneaker.model.User;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name="user")
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id", nullable = false)
    private Long userId;
    private String username;
    private String password;
    private String email;
    private Date created_at;
    private String phone;
    private String address;
    private boolean gender;

    public User(){
    }


}
