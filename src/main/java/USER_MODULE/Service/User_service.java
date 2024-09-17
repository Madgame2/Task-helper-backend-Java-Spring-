package USER_MODULE.Service;

import USER_MODULE.Entity.User;
import USER_MODULE.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class User_service {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public User_service(UserRepository repository, @Lazy PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public int registerUser(String email, String password) {
        if (repository.findByEmail(email).isPresent()) {
            return -1;
        }
        User new_user = new User();
        new_user.setEmail(email);
        new_user.setPassword(passwordEncoder.encode(password)); // Хэширование пароля
        repository.save(new_user);
        return 0;
    }

    public Optional<User> find_user_by_email(String email) {
        return repository.findByEmail(email);
    }
}
