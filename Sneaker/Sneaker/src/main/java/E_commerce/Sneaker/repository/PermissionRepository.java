package E_commerce.Sneaker.repository;

import E_commerce.Sneaker.model.Role.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, String> {
}
