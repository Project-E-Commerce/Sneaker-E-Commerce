package E_commerce.Sneaker.repository;

import E_commerce.Sneaker.model.Order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
