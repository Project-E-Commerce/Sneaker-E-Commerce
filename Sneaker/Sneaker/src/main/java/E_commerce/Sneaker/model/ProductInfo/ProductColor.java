package E_commerce.Sneaker.model.ProductInfo;

import E_commerce.Sneaker.model.Product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_color")
public class ProductColor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productColorId;

    private String color;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}

