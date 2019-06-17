package hyperlogy.admin.user.repository;

import hyperlogy.admin.user.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
//    Iterable<User> findByNameContaining(String term);
    User findByUsername(String username);
    User findByEmail(String email);
    List<User> findByUsernameContaining(String username);
}
