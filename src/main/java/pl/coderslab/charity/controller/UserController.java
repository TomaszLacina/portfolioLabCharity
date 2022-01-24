package pl.coderslab.charity.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.CurrentUser;
import pl.coderslab.charity.service.UserService;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.UserRepository;
import javax.validation.Valid;


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
    public String editUser(@AuthenticationPrincipal CurrentUser currentUser, Model model){
        User user = userRepository.getById(currentUser.getUser().getId());
        model.addAttribute("user", user);
        return "user/edit";
    }

    @PostMapping("/edit")
    public String mergeUser(@ModelAttribute("user") @Valid User user, BindingResult result, @AuthenticationPrincipal CurrentUser customUser){
        if(result.hasErrors()){
            return "user/edit";
        }
        userService.saveUser(user);
        return "redirect:/dashboard/index";
    }
}
