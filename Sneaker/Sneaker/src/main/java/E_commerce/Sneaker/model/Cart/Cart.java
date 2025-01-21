package E_commerce.Sneaker.model.Cart;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cart_id;

    @Column(nullable = false)
    private Long user_id;

    @Column(nullable = false)
    private Long product_id;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private double total_price;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;
}

