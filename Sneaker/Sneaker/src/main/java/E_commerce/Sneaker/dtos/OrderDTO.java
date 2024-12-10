package E_commerce.Sneaker.dtos;

import E_commerce.Sneaker.model.Order.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderDTO extends Order {
    private String user_name;
}
