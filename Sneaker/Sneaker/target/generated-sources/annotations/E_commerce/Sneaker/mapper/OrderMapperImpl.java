package E_commerce.Sneaker.mapper;

import E_commerce.Sneaker.dtos.OrderDTO;
import E_commerce.Sneaker.model.Order.Order;
import E_commerce.Sneaker.model.Product.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-04T01:00:43+0700",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public Order toOrder(OrderDTO request) {
        if ( request == null ) {
            return null;
        }

        Order order = new Order();

        order.setOrderId( request.getOrderId() );
        order.setName( request.getName() );
        order.setAddress( request.getAddress() );
        List<Product> list = request.getProducts();
        if ( list != null ) {
            order.setProducts( new ArrayList<Product>( list ) );
        }
        order.setPhone( request.getPhone() );
        order.setNumber( request.getNumber() );
        order.setAddressFrom( request.getAddressFrom() );
        order.setAddressTo( request.getAddressTo() );
        order.setCreatedAt( request.getCreatedAt() );
        order.setUpdatedAt( request.getUpdatedAt() );
        order.setDeletedAt( request.getDeletedAt() );

        return order;
    }
}
