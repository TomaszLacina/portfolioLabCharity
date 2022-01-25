package pl.coderslab.charity.controller;

import net.bytebuddy.utility.RandomString;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.service.UserService;
import pl.coderslab.charity.entity.User;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/password")
public class ForgotPasswordController {

    private final JavaMailSender mailSender;
    private final UserService userService;

    public ForgotPasswordController(JavaMailSender mailSender, UserService userService) {
        this.mailSender = mailSender;
        this.userService = userService;
    }

    @GetMapping("/forgot_password")
    public String showForgotPasswordForm() {
        return "password/forgot_password";
    }

    @PostMapping("/forgot_password")
    public String processForgotPassword(HttpServletRequest request, Model model) throws MessagingException, UnsupportedEncodingException {
        String email = request.getParameter("email");
        String token = RandomString.make(30);

            userService.updateResetPasswordToken(token, email);
            String resetPasswordLink = getSiteURL(request) + "/password/reset_password?token=" + token;
            userService.sendEmail(email, resetPasswordLink);
            model.addAttribute("message", "We have sent a reset password link to your email. Please check.");

        return "/login";
    }

    public void sendEmail(){

    }


    @GetMapping("/reset_password")
    public String showResetPasswordForm(@Param(value = "token") String token, Model model) {
        User user = userService.getByResetPasswordToken(token);
        model.addAttribute("token", token);

        return "password/reset_password";
    }

    @PostMapping("/reset_password")
    public String processResetPassword(@ModelAttribute("user") @Valid User user, HttpServletRequest request, Model model) {
        String token = request.getParameter("token");
        String password = request.getParameter("password");
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            System.out.println("Passwords dont match!");
            return "password/reset_password";
        } else {
            User user1 = userService.getByResetPasswordToken(token);
            userService.updatePassword(user1, password);

            return "/";
        }
    }

    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }
}