package hyperlogy.admin.user.repository;

import hyperlogy.admin.user.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, String> {
    Role findByName(String name);
}
