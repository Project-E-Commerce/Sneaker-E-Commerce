package E_commerce.Sneaker.controller;

import E_commerce.Sneaker.model.User;
import E_commerce.Sneaker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value="/")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value="/add")
    public String addEmployee(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "signup";
    }

}
