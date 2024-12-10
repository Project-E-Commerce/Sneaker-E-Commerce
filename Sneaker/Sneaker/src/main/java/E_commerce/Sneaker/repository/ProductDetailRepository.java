package E_commerce.Sneaker.repository;

import E_commerce.Sneaker.model.ProductInfo.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {
}
