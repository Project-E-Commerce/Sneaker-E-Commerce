package E_commerce.Sneaker.dtos.response;

import lombok.*;

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
public class RoleResponse {
    String permission_name;
    String description;
    Set<String> permissions;
}
