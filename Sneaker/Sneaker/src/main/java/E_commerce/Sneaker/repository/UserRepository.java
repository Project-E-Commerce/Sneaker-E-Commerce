package E_commerce.Sneaker.repository;


import E_commerce.Sneaker.model.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByUserId (Long id);
    boolean existsByUsername(String username);
}
