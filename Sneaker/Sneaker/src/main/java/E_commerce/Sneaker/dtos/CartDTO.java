package E_commerce.Sneaker.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CartDTO {
    private Long cart_id;
    private Long user_id;
    private Long product_id;
    private int quantity;
    private double total_price;
    private String product_name;
    private double product_price;
}
