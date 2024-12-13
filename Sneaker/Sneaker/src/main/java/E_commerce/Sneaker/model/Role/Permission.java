package E_commerce.Sneaker.model.Role;

import E_commerce.Sneaker.model.User.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Permission {
    @Id
    private String permission_name;

    private String description;


}
