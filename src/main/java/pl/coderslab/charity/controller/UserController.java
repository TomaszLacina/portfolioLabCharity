package pl.coderslab.charity.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.CurrentUser;
import pl.coderslab.charity.SpringDataUserDetailsService;
import pl.coderslab.charity.UserService;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.UserRepository;

import javax.validation.Valid;
import java.util.Collections;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }


    @GetMapping("/edit")
    public String prepareEdit(@RequestParam long idToEdit, Authentication authentication, Model model) {
        idToEdit = ((CurrentUser) authentication.getPrincipal()).getId();
        model.addAttribute("user", userRepository.findById(idToEdit));
        /*model.addAttribute("user", new User());*/
        return "user/edit";
    }


    /*@PostMapping("/edit")
    public String merge(@ModelAttribute("user") @Valid User user, BindingResult result) {
        if(result.hasErrors()) {
            return "user/edit";
        }
        userService.save(user);
        return "redirect:/dashboard/index";
    }*/
}
