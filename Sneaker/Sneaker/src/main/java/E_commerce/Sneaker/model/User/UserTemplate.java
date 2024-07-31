package E_commerce.Sneaker.model.User;

import E_commerce.Sneaker.model.Role.Role;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
public class UserTemplate {
    @Length(min=6, max=50)
    private String username;
    @Pattern(regexp = "^(?=.*\\d)(?=.*[A-Z]).{6,50}$",
            message = "6 characters min (at least 1 digit & 1 uppercase letter)")
    private String password;
    private String email;
    private Date created_at;
    private String phone;
    private String address;
    private boolean gender;
    private Set<Role> roles;
    
}
