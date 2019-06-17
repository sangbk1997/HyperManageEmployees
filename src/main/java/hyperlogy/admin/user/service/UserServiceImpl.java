package hyperlogy.admin.user.service;

import hyperlogy.admin.user.model.User;
import hyperlogy.admin.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> search(String term) {
        return userRepository.findByUsernameContaining(term);
    }

    @Override
    public Optional<User> findOne(String id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        User newUser = new User();
        newUser.setId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Optional<User> delete(String id) throws Exception {
        Optional<User> user = findOne(id);
        try {
            userRepository.deleteById(id);
            return user;
        }catch (Exception e){
            throw new Exception("Error occur in delete User !");
        }
    }
}
