package E_commerce.Sneaker.Service.Order;

import E_commerce.Sneaker.model.Order.Order;

import java.util.List;

public interface OrderService {
    Order getOrderById(Long id);
    Order createOrder(Order order);
    Order updateOrder(Long id  ,Order order);
    List<Order> getAllOrders();
    boolean deleteOrder(Long id);
}
