package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.entity.Role;
import pl.coderslab.charity.entity.User;

import java.util.Arrays;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>{

    User findByUsername(String username);

    User getById(long idToEdit);

    List<User> findByRoles(String role);

    /*List<User> findAllByEmail(String query);*/

    List<User> findAllByUsername(String query);

    List<User> findAllByRolesId(long idRole);

    List<User> findAllById(long id);

    User findByVerificationCode(String code);

    User findByResetPasswordToken(String token);

    User findByEmail(String email);
}