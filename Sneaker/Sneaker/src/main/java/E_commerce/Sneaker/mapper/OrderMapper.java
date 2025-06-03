package E_commerce.Sneaker.mapper;


import E_commerce.Sneaker.dtos.OrderDTO;
import E_commerce.Sneaker.model.Order.Order;
import E_commerce.Sneaker.model.User.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mapping(target="user", source = "user_name", ignore = true)
    Order toOrder(OrderDTO request);

    default User mapUserFromName(String username){
        if(username == null) return null;
        return User.builder().username(username).build();
    }
}
