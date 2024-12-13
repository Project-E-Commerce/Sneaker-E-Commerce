package E_commerce.Sneaker.dtos.response;

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
public class PermissionResponse {
    String permission_name;
    String description;
}
