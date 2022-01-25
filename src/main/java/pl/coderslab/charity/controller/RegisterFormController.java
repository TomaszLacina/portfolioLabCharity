package pl.coderslab.charity.controller;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.service.UserService;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.RoleRepository;
import pl.coderslab.charity.repository.UserRepository;


import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;

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
    public String addRegister(Model model) {
        model.addAttribute("user", new User());
        return "/register/add";
    }

    @PostMapping("/add")
    public String saveRegister(@ModelAttribute("user") @Valid UserRegisterDto userReg, BindingResult result, HttpServletRequest request) throws MessagingException, UnsupportedEncodingException {
        System.out.println("HERE" + user.toString());
        
        if(!isPasswordValid(userReg)){ // nowa metoda na to zeby sprawdzic czy hasla są takie same, meotda true/false ma zwracac
            model.setAttribute("error","blabla");
            return "/register/add";
        }
        
        User user = new User();
        
        user.setName(userReg.getName);
        user.setPassword(userReg.getPassword());
        ...
            ..
            
            ...
            
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            System.out.println("Passwords dont match!");
            return "/register/add";
        } else {
            System.out.println("SUCCESS");
            userService.save(user, getSiteURL(request));
            return "redirect:/login";
        }
    }

    @GetMapping("/verify")
    public String verifyUser(@Param("code") String code) {
        if (userService.verify(code)) {
            return "register/verify_success";
        } else {
            return "register/verify_fail";
        }
    }

    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }
}
