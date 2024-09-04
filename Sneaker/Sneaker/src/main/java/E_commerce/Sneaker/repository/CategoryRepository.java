package E_commerce.Sneaker.repository;

import E_commerce.Sneaker.model.Category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
