package E_commerce.Sneaker.mapper;

import E_commerce.Sneaker.dtos.request.PermissionRequest;
import E_commerce.Sneaker.dtos.response.PermissionResponse;
import E_commerce.Sneaker.model.Role.Permission;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-04T01:00:44+0700",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class PermissionMapperImpl implements PermissionMapper {

    @Override
    public Permission toPermission(PermissionRequest request) {
        if ( request == null ) {
            return null;
        }

        Permission.PermissionBuilder permission = Permission.builder();

        permission.permission_name( request.getPermission_name() );
        permission.description( request.getDescription() );

        return permission.build();
    }

    @Override
    public PermissionResponse toPermissionResponse(Permission permission) {
        if ( permission == null ) {
            return null;
        }

        PermissionResponse.PermissionResponseBuilder permissionResponse = PermissionResponse.builder();

        permissionResponse.permission_name( permission.getPermission_name() );
        permissionResponse.description( permission.getDescription() );

        return permissionResponse.build();
    }
}
