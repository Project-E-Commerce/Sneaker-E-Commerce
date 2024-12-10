package E_commerce.Sneaker.dtos.response;

import lombok.*;

/**
 *  This class is a dto for verifying a JWT token
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IntrospectResponse {
    boolean valid;
}
