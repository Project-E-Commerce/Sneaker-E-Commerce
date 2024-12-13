package E_commerce.Sneaker.mapper;

import E_commerce.Sneaker.dtos.UserDTO;
import E_commerce.Sneaker.dtos.request.PermissionRequest;
import E_commerce.Sneaker.dtos.response.PermissionResponse;
import E_commerce.Sneaker.dtos.response.UserResponseDTO;
import E_commerce.Sneaker.model.Role.Permission;
import E_commerce.Sneaker.model.User.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);
    PermissionResponse toPermissionResponse(Permission permission);
}
