package E_commerce.Sneaker.dtos.response;

import lombok.*;

/**
 *  This class is a dto for authenticating a user
 */

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {
    boolean isAuthenticated;
    String token;
}
