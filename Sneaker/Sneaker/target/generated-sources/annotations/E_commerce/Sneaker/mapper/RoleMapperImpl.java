package E_commerce.Sneaker.mapper;

import E_commerce.Sneaker.dtos.request.RoleRequest;
import E_commerce.Sneaker.dtos.response.RoleResponse;
import E_commerce.Sneaker.model.Role.Role;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-24T16:08:27+0700",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public Role toRole(RoleRequest request) {
        if ( request == null ) {
            return null;
        }

        Role.RoleBuilder role = Role.builder();

        role.role_name( request.getRole_name() );
        role.description( request.getDescription() );

        return role.build();
    }

    @Override
    public RoleResponse toRoleResponse(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleResponse.RoleResponseBuilder roleResponse = RoleResponse.builder();

        roleResponse.description( role.getDescription() );

        return roleResponse.build();
    }
}
