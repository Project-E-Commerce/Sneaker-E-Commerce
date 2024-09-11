package E_commerce.Sneaker.dtos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.*;

/**
 * this class is for adding new User entity when calling the add user function
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserCreationDTO implements Serializable {
    private String username;
    private String password;
    private String email;
    private Date created_at;
    private String phone;
    private String address;
    private boolean gender;
    private List<Long> roleIds;

}
