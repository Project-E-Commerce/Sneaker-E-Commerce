package E_commerce.Sneaker.Service.User;

import E_commerce.Sneaker.dtos.UserDTO;
import E_commerce.Sneaker.dtos.response.UserResponseDTO;
import E_commerce.Sneaker.enums.Role;
import E_commerce.Sneaker.exception.AppException;
import E_commerce.Sneaker.exception.ErrorCode;
import E_commerce.Sneaker.mapper.UserMapper;
import E_commerce.Sneaker.model.User.User;

import E_commerce.Sneaker.repository.UserRepository;
import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

/**
 * This class contains crud of user entity
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(UserDTO request){

        if(userRepository.existsByUsername(request.getUsername())){
            throw new AppException(ErrorCode.USERNAME_EXISTED);
        }

        User user = userMapper.toUser(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        HashSet<String> roles = new HashSet<>();
        roles.add(Role.USER.name());
//        user.setRoles(roles);

        return userRepository.save(user);
    }

    public UserResponseDTO getMyInfo(){
        var context = SecurityContextHolder.getContext();
        String name = context.getAuthentication().getName();

       User user = userRepository.findByUsername(name).orElseThrow(
               () -> new AppException(ErrorCode.USER_NOT_FOUND)
       );

        return userMapper.toUserResponseDTO(user);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @PostAuthorize("returnObject .username == authentication.name")
    public UserResponseDTO getUser(Long id){
        return userMapper.toUserResponseDTO(userRepository.findByUserId(id)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND)));
    }

    public UserResponseDTO updateUser(Long userId,
                            UserDTO request){
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
        userMapper.updateUser(user, request);

        return userMapper.toUserResponseDTO(userRepository.save(user));
    }


    public void deleteUser(Long userId){
        userRepository.deleteById(userId);
    }


}
