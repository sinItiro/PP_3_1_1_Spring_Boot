package akademy.kata.springboot.service;

import akademy.kata.springboot.model.User;
import akademy.kata.springboot.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Long id) {
        return userRepository.getById(id);
    }
    public List<User> findAll() {
        return userRepository.findAll();
    }
    public void saveUser(User user) {
        userRepository.save(user);
    }
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

}
