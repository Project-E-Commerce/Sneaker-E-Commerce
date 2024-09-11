package E_commerce.Sneaker.dtos;

import lombok.*;
import java.io.Serializable;
import java.util.List;

/**
 * this class reflect the User class when sending data to client
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {
        private String username;
        private String email;
        private String gender;
        private List<RoleDTO> roles;

}
