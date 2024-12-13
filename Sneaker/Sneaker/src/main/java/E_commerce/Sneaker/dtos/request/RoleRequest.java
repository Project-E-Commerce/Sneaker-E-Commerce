package E_commerce.Sneaker.dtos.request;

import lombok.*;

import java.util.List;
import java.util.Set;

/**
 *  This class is a dto for verifying a JWT token
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class RoleRequest {
    String role_name;
    String description;
    Set<String> permissions;
}
