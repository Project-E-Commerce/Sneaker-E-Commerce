package E_commerce.Sneaker.controller;

import E_commerce.Sneaker.Service.User.UserService;
import E_commerce.Sneaker.dtos.response.ApiResponse;
import E_commerce.Sneaker.dtos.UserDTO;
import E_commerce.Sneaker.dtos.response.UserResponseDTO;
import E_commerce.Sneaker.model.User.User;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;


    @PostMapping("/create")
    ApiResponse<User> createUser(@RequestBody @Valid UserDTO request){
        ApiResponse<User> apiResponse = new ApiResponse<>();

        apiResponse.setResult(userService.createUser(request));

        return apiResponse;
    }

    /*@GetMapping
    List<User> getUsers(){
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("Username: {}", authentication.getName());
        authentication.getAuthorities().forEach(grantedAuthority -> log.info(grantedAuthority.getAuthority()));
        return userService.getUsers();
    }*/

    @GetMapping
    ApiResponse<List<User>> getUsers(){
        var authentication = SecurityContextHolder.getContext().getAuthentication();

        log.info("Username: {}", authentication.getName());
        authentication.getAuthorities().forEach(grantedAuthority -> log.info(grantedAuthority.getAuthority()));

        return ApiResponse.<List<User>>builder()
                .result(userService.getUsers())
                .build();
    }

    /*@GetMapping("/{userId}")
    UserResponseDTO getUser(@PathVariable("userId") Long userId){
        return userService.getUser(userId);
    }*/


    @GetMapping("/{userId}")
    ApiResponse<UserResponseDTO> getUser(@PathVariable("userId") Long userId){
        return ApiResponse.<UserResponseDTO>builder()
                .result(userService.getUser(userId))
                .build();
    }

    @GetMapping("/myInfo")
    ApiResponse<UserResponseDTO> getMyInfo(){
        return ApiResponse.<UserResponseDTO>builder()
                .result(userService.getMyInfo())
                .build();
    }

    @PutMapping("/update/{userId}")
    UserResponseDTO updateUser(@PathVariable Long userId,
                    @RequestBody UserDTO request){
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
        return "user has been deleted";
    }
}



























































