package E_commerce.Sneaker.repository;

import E_commerce.Sneaker.model.ProductInfo.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
}
