package E_commerce.Sneaker.mapper;

import E_commerce.Sneaker.dtos.UserCreationDTO;
import E_commerce.Sneaker.dtos.UserDTO;
import E_commerce.Sneaker.model.User.User;
import E_commerce.Sneaker.model.User.UserTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.management.InstanceAlreadyExistsException;
import java.util.stream.Collectors;

/**
 * this class allows the data exchange from UserCreationDTO to User and from User to UserDTO
 */
public class UserMapper {
    private static UserMapper INSTANCE;

    public static UserMapper getInstance(){
        if (INSTANCE == null){
            INSTANCE = new UserMapper();
        }
        return INSTANCE;
    }

    public User toEntity(UserCreationDTO creationDTO,
                        UserTemplate ut,
                         PasswordEncoder encoder){
        User user = new User(ut, encoder);
        user.setUsername(creationDTO.getUsername());
        user.setPassword(creationDTO.getPassword());
        user.setEmail(creationDTO.getEmail());
        user.setCreated_at(creationDTO.getCreated_at());
        user.setAddress(creationDTO.getAddress());
        user.setGender(creationDTO.isGender());
        return user;
    }
    public UserDTO toDTO(User user){
        UserDTO dto = new UserDTO();
        dto.setUsername(user.getUsername());
        dto.setRoles(user.getRoles().stream()
                .map(role -> RoleMapper.getInstance().toDTO(role))
                .collect(Collectors.toList()));
        return dto;
    }
}
