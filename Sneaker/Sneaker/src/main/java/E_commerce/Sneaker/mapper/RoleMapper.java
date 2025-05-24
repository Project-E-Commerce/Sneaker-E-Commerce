package E_commerce.Sneaker.mapper;

import E_commerce.Sneaker.dtos.RoleDTO;
import E_commerce.Sneaker.dtos.request.RoleRequest;
import E_commerce.Sneaker.dtos.response.RoleResponse;
import E_commerce.Sneaker.model.Role.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * this class allows the data exchange from Role class and RoleDTO classes
 */

@Mapper(componentModel = "spring")
public interface RoleMapper {

    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    @Mapping(target = "permissions", ignore = true)
    RoleResponse toRoleResponse(Role role);

}