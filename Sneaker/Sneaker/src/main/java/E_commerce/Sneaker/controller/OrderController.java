package E_commerce.Sneaker.controller;

import E_commerce.Sneaker.Service.Order.OrderService;
import E_commerce.Sneaker.Service.User.UserService;
import E_commerce.Sneaker.dtos.OrderDTO;
import E_commerce.Sneaker.dtos.UserDTO;
import E_commerce.Sneaker.dtos.response.UserResponseDTO;
import E_commerce.Sneaker.model.Order.Order;
import E_commerce.Sneaker.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<List<OrderDTO>> getList(){
        try {
            List<Order> list = orderRepository.findAll();
            var listDTO = new ArrayList<OrderDTO>();
            for (Order o : list) {
                UserResponseDTO user = userService.getUser(o.getUserId());
                OrderDTO orderDTO = new OrderDTO();
                orderDTO.setOrder_id(o.getOrder_id());
                orderDTO.setName(o.getName());
                orderDTO.setAddress(o.getAddress());
                orderDTO.setPhone(o.getPhone());
                orderDTO.setAddress_from(o.getAddress_from());
                orderDTO.setAddress_to(o.getAddress_to());
                orderDTO.setCreated_at(o.getCreated_at());
                orderDTO.setUpdate_at(o.getUpdate_at());
                listDTO.add(orderDTO);
            }
            return ResponseEntity.ok(listDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id) {
        try {
            Optional<Order> optionalOrder = orderRepository.findById(id);
            if (optionalOrder.isPresent()) {
                Order order = optionalOrder.get();
                UserResponseDTO user = userService.getUser(order.getUserId());
                OrderDTO orderDTO = new OrderDTO();
                orderDTO.setOrder_id(order.getOrder_id());
                orderDTO.setName(order.getName());
                orderDTO.setAddress(order.getAddress());
                orderDTO.setPhone(order.getPhone());
                orderDTO.setCreated_at(order.getCreated_at());
                orderDTO.setUpdate_at(order.getUpdate_at());

                return ResponseEntity.ok(orderDTO);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        try {
            Order savedOrder = orderRepository.save(order);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedOrder);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order updatedOrder) {
        try {
            Optional<Order> optionalOrder = orderRepository.findById(id);
            if (optionalOrder.isPresent()) {
                Order existingOrder = optionalOrder.get();
                existingOrder.setName(updatedOrder.getName());
                existingOrder.setAddress(updatedOrder.getAddress());
                existingOrder.setPhone(updatedOrder.getPhone());
                existingOrder.setNumber(updatedOrder.getNumber());
                existingOrder.setAddress_from(updatedOrder.getAddress_from());
                existingOrder.setAddress_to(updatedOrder.getAddress_to());

                Order savedOrder = orderRepository.save(existingOrder);
                return ResponseEntity.ok(savedOrder);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        try {
            if (orderRepository.existsById(id)) {
                orderRepository.deleteById(id);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
