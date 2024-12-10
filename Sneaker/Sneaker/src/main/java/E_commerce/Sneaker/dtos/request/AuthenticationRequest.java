package E_commerce.Sneaker.dtos.request;

import lombok.*;

/**
 *  This class is a dto for authenticating a user
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthenticationRequest {
    private String username;
    private String password;
}

