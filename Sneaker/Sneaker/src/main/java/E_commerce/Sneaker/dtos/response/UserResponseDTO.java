package E_commerce.Sneaker.dtos.response;

import lombok.*;

import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserResponseDTO {
    private Long userId;
    private String username;
    private String email;
    private Date created_at;
    private String phone;
    private String address;
    private boolean gender;
    Set<String> roles;
}
