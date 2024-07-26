package E_commerce.Sneaker.controller;

import E_commerce.Sneaker.model.User.User;
import E_commerce.Sneaker.model.User.UserTemplate;
import E_commerce.Sneaker.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value="/")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping(value="/signup")
    public String signup(Model model){
        model.addAttribute("user", new UserTemplate());
        return "signup";
    }

    @PostMapping("/signup")
    public String signupHandle(Model model, PasswordEncoder encoder,
                               @Valid UserTemplate ut,
                               BindingResult result){
        if(result.hasErrors()){
            model.addAttribute("user", ut);
            return "signup";
        }else{
            model.addAttribute("user", new UserTemplate());
            model.addAttribute("sucess", true);
            userRepository.save(new User(ut, encoder));
            //chua hieu loi gi
            return "signup";
        }
    }

}
