package E_commerce.Sneaker.repository;


import E_commerce.Sneaker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
