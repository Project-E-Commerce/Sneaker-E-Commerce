package E_commerce.Sneaker.Service.User;

import E_commerce.Sneaker.dtos.UserCreationDTO;
import E_commerce.Sneaker.dtos.UserDTO;
import E_commerce.Sneaker.model.User.User;
import E_commerce.Sneaker.model.User.UserTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface UserService {
    UserDTO createUser(UserCreationDTO creationDTO, UserTemplate ut,
                       PasswordEncoder encoder);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
    UserDetails loadUserByUsername(String username);
    User getUserById(Long id);
}
