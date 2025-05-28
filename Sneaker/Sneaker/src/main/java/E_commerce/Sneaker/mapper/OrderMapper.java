package E_commerce.Sneaker.mapper;


import E_commerce.Sneaker.dtos.OrderDTO;
import E_commerce.Sneaker.model.Order.Order;
import E_commerce.Sneaker.model.User.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mapping(target = "orders", ignore = true)
    User toOrder(OrderDTO request);

}
