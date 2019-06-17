package hyperlogy.admin.user.service;

import hyperlogy.admin.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Iterable<User> findAll();
    List<User> search(String term);
    Optional<User> findOne(String id);
    User save(User user);
    Optional<User> delete(String id) throws Exception;
}
