package E_commerce.Sneaker.Service.User;

import E_commerce.Sneaker.dtos.UserDTO;
import E_commerce.Sneaker.dtos.response.UserResponseDTO;
import E_commerce.Sneaker.exception.AppException;
import E_commerce.Sneaker.exception.ErrorCode;
import E_commerce.Sneaker.mapper.UserMapper;
import E_commerce.Sneaker.model.User.User;

import E_commerce.Sneaker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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

    public User createUser(UserDTO request){

        if(userRepository.existsByUsername(request.getUsername())){
            throw new AppException(ErrorCode.USERNAME_EXISTED);
        }

        User user = userMapper.toUser(request);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        /*user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setCreated_at(request.getCreated_at());
        user.setPhone(request.getPhone());
        user.setAddress(request.getAddress());
        user.setGender(request.isGender());*/

        return userRepository.save(user);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public UserResponseDTO getUser(Long id){
        return userMapper.toUserResponseDTO(userRepository.findByUserId(id)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND)));
    }

    public UserResponseDTO updateUser(Long userId,
                            UserDTO request){
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));
        userMapper.updateUser(user, request);
        /*user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setCreated_at(request.getCreated_at());
        user.setPhone(request.getPhone());
        user.setAddress(request.getAddress());
        user.setGender(request.isGender());*/
        return userMapper.toUserResponseDTO(userRepository.save(user));
    }

    public void deleteUser(Long userId){
        userRepository.deleteById(userId);
    }


}
