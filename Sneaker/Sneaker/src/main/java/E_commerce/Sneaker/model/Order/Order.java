package E_commerce.Sneaker.model.Order;

import E_commerce.Sneaker.model.Product.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="order_id", nullable = false)
    private Long order_id;
    private String username;
    private List<Product> product_id;
    private int number;
    private Date order_date;
    private String note;
}
