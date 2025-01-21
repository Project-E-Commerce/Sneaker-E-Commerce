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
        existingOrder.setUpdate_at(order.getUpdate_at());
        existingOrder.setPhone(order.getPhone());
        existingOrder.setAddress(order.getAddress());
        existingOrder.setAddress_from(order.getAddress_from());
        existingOrder.setAddress_to(order.getAddress_to());
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
