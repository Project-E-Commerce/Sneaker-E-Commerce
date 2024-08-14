package E_commerce.Sneaker.model.User;

import E_commerce.Sneaker.model.Role.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.prefs.PreferenceChangeEvent;

@Entity
@Getter
@Setter
@Table(name="user")
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id", nullable = false)
    private Long id;
    private String username;
    private String password;
    private String email;
    private Date created_at;
    private String phone;
    private String address;
    private boolean gender;

    public User(UserTemplate ut, PasswordEncoder encoder){
        this.username = ut.getUsername();
        this.password = ut.getPassword();
        this.email = ut.getEmail();
        this.created_at = ut.getCreated_at();
        this.phone = ut.getPhone();
        this.address = ut.getAddress();
        this.gender = ut.isGender();
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name="users_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name ="role_id", referencedColumnName = "role_id")}
    )
    private Set<Role> roles = new HashSet<>();

}
