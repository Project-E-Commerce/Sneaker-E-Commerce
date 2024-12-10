package E_commerce.Sneaker.controller;

import E_commerce.Sneaker.Service.User.UserService;
import E_commerce.Sneaker.dtos.response.ApiResponse;
import E_commerce.Sneaker.dtos.UserDTO;
import E_commerce.Sneaker.dtos.response.UserResponseDTO;
import E_commerce.Sneaker.model.User.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping
    ApiResponse<User> createUser(@RequestBody @Valid UserDTO request){
        ApiResponse<User> apiResponse = new ApiResponse<>();

        apiResponse.setResult(userService.createUser(request));

        return apiResponse;
    }

    @GetMapping
    List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    UserResponseDTO getUser(@PathVariable("userId") Long userId){
        return userService.getUser(userId);
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



























































