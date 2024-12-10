package E_commerce.Sneaker.controller;

import E_commerce.Sneaker.Service.Order.OrderService;
import E_commerce.Sneaker.Service.User.UserService;
import E_commerce.Sneaker.dtos.OrderDTO;
import E_commerce.Sneaker.dtos.response.UserResponseDTO;
import E_commerce.Sneaker.model.Order.Order;
import E_commerce.Sneaker.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/order") // router
public class OrderController {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderService orderService;
    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<OrderDTO> getList(){
        try {
            List<Order> list = orderRepository.findAll();
            var listDTO = new ArrayList<OrderDTO>();
            for (Order o : list) {
                UserResponseDTO user = userService.getUser(o.getUserId());
            }
            return listDTO;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
