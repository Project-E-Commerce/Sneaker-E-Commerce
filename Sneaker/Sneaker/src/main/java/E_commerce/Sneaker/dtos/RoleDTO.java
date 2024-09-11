package E_commerce.Sneaker.dtos;

import java.io.Serializable;
import lombok.*;

/**
 * this class reflect the Role class when sending data to client
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO implements Serializable {
    private Long id;
    private String name;
}
