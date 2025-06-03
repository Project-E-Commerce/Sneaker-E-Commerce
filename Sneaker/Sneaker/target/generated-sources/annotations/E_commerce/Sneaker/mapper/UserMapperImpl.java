package E_commerce.Sneaker.mapper;

import E_commerce.Sneaker.dtos.UserDTO;
import E_commerce.Sneaker.dtos.response.UserResponseDTO;
import E_commerce.Sneaker.model.User.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-04T01:00:44+0700",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toUser(UserDTO request) {
        if ( request == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.username( request.getUsername() );
        user.password( request.getPassword() );
        user.email( request.getEmail() );
        user.created_at( request.getCreated_at() );
        user.phone( request.getPhone() );
        user.address( request.getAddress() );
        user.gender( request.isGender() );

        return user.build();
    }

    @Override
    public UserResponseDTO toUserResponseDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponseDTO userResponseDTO = new UserResponseDTO();

        userResponseDTO.setUserId( user.getUserId() );
        userResponseDTO.setUsername( user.getUsername() );
        userResponseDTO.setEmail( user.getEmail() );
        userResponseDTO.setCreated_at( user.getCreated_at() );
        userResponseDTO.setPhone( user.getPhone() );
        userResponseDTO.setAddress( user.getAddress() );
        userResponseDTO.setGender( user.isGender() );

        return userResponseDTO;
    }

    @Override
    public void updateUser(User user, UserDTO request) {
        if ( request == null ) {
            return;
        }

        user.setUsername( request.getUsername() );
        user.setPassword( request.getPassword() );
        user.setEmail( request.getEmail() );
        user.setCreated_at( request.getCreated_at() );
        user.setPhone( request.getPhone() );
        user.setAddress( request.getAddress() );
        user.setGender( request.isGender() );
    }
}
