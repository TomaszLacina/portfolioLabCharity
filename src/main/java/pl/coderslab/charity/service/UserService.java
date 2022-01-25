package pl.coderslab.charity.service;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.entity.User;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

@Service
public interface UserService {

    User findByUserName(String name);

    @Transactional
    void save(User user, String siteURL) throws MessagingException, UnsupportedEncodingException;

    @Transactional
    void saveUser(User user);

    @Transactional
    void saveAdmin(User user);

    @Transactional
    void savePassword(User user);

    @Transactional
    void sendVerificationEmail(User user, String siteURL) throws MessagingException, UnsupportedEncodingException;

    @Transactional
    boolean verify(String verificationCode);

    @Transactional
    void updateResetPasswordToken(String token, String email);

    @Transactional
    User getByResetPasswordToken(String token);

    @Transactional
    void updatePassword(User user, String newPassword);

    @Transactional
    void sendEmail(String recipientEmail, String link)
            throws MessagingException, UnsupportedEncodingException;
}