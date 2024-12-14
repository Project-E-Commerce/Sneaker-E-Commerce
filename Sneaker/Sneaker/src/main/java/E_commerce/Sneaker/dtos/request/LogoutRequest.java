package E_commerce.Sneaker.dtos.request;

import lombok.*;

/**
 *  This class is a dto for verifying a JWT token
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class LogoutRequest {
    String token;
}
