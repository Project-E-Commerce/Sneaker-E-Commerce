package E_commerce.Sneaker.dtos;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * this class reflect the User class when sending data to client
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @Size(min = 6, message = "INVALID_USERNAME") // the message must be String
    private String username;

    @Pattern(regexp = "^(?=.*\\d)(?=.*[A-Z]).{6,50}$",
            message = "INVALID_PASSWORD")
    private String password;
    private String email;
    private Date created_at;
    private String phone;
    private String address;
    private boolean gender;
    List<String> roles;
}
