package pl.coderslab.charity.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.UserService;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.RoleRepository;
import pl.coderslab.charity.repository.UserRepository;


import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegisterFormController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public RegisterFormController(UserService userService, UserRepository userRepository, RoleRepository roleRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    @GetMapping("/add")
    public String prepareAdd(Model model) {
        model.addAttribute("user", new User());
        return "/register/add";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute("users") @Valid User user, BindingResult result) {
        if(result.hasErrors()){
            return "/register/add";
        }
        /*userRepository.save(user);*/
        userService.save(user);
        return "redirect:/login";
    }

}
