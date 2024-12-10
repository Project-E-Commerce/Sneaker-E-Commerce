package E_commerce.Sneaker.mapper;

import E_commerce.Sneaker.dtos.UserDTO;
import E_commerce.Sneaker.dtos.response.UserResponseDTO;
import E_commerce.Sneaker.model.User.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserDTO request);
    UserResponseDTO toUserResponseDTO(User user);
    void updateUser(@MappingTarget User user, UserDTO request);
}
