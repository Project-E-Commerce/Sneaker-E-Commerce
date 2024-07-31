package E_commerce.Sneaker.repository;

import E_commerce.Sneaker.model.Product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
