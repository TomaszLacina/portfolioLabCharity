package pl.coderslab.charity;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.entity.User;

@Service
public interface UserService {

    User findByUserName(String name);
    @Transactional
    void save(User user);

}