package E_commerce.Sneaker.repository;


import E_commerce.Sneaker.model.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>, PagingAndSortingRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByUserId (Long id);
    boolean existsByUsername(String username);
}
