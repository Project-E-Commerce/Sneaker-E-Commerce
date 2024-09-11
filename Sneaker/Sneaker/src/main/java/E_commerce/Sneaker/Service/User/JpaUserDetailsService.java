package E_commerce.Sneaker.Service.User;

import E_commerce.Sneaker.dtos.UserCreationDTO;
import E_commerce.Sneaker.dtos.UserDTO;
import E_commerce.Sneaker.mapper.UserMapper;
import E_commerce.Sneaker.model.Role.Role;
import E_commerce.Sneaker.model.User.MyUserDetails;
import E_commerce.Sneaker.model.User.User;
import E_commerce.Sneaker.model.User.UserTemplate;
import E_commerce.Sneaker.repository.RoleRepository;
import E_commerce.Sneaker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class JpaUserDetailsService implements UserService, UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    //dto
    public UserDTO createUser(UserCreationDTO creationDTO,
                              UserTemplate ut,
                              PasswordEncoder encoder){
        User user = UserMapper.getInstance().toEntity(creationDTO, ut, encoder);
        List<Role> roles = roleRepository.findAllById(creationDTO.getRoleIds());
        user.setRoles((Set<Role>) roles);
        return UserMapper.getInstance().toDTO(userRepository.save(user));
    }


    @Override
    public UserDetails loadUserByUsername(String username)
        throws UsernameNotFoundException{
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isPresent()){
            return new MyUserDetails(user.get());
        }else{
            throw new UsernameNotFoundException("User not found: " + username);
        }
    }
    @Override
    public User getUserById(Long id){
        return userRepository.getById(id);
    }

    @Override
    public User updateUser(Long id, User user){
        User existingUser = getUserById(user.getId());
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        existingUser.setEmail(user.getEmail());
        existingUser.setGender(user.isGender());
        existingUser.setAddress(user.getAddress());
        existingUser.setPhone(user.getPhone());
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long id){
        User checkUser = getUserById(id);
        if(checkUser != null){
            userRepository.deleteById(id);
        }
    }
}
