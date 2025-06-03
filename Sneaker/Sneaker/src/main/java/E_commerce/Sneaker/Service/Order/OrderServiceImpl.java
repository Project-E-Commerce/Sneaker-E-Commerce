package E_commerce.Sneaker.Service.Order;

import E_commerce.Sneaker.model.Order.Order;
import E_commerce.Sneaker.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderRepository orderRepository ;


    @Override
    public Order getOrderById(Long id){
        return orderRepository.getById(id);
    }

    @Override
    public Order createOrder(Order order){
        return orderRepository.save(order);
    }

    /// chua chac lam
    @Override
    public Order updateOrder(Long id  ,Order order){
        Order existingOrder = getOrderById(id);
        existingOrder.setName(order.getName());
        existingOrder.setNumber(order.getNumber());
        existingOrder.setUpdatedAt(order.getUpdatedAt());
        existingOrder.setPhone(order.getPhone());
        existingOrder.setAddress(order.getAddress());
        existingOrder.setAddressFrom(order.getAddressFrom());
        existingOrder.setAddressTo(order.getAddressTo());
        return orderRepository.save(existingOrder);
    }

    @Override
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    @Override
    public boolean deleteOrder(Long id){
        Order checkOrder = getOrderById(id);
        if (checkOrder != null){
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
