package E_commerce.Sneaker.model.ProductInfo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "product_color")
@Entity
public class ProductColor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_color_id")
    private Long product_color_id;
    @Column(name = "product_id")
    private Long product_id;
    @Column(name = "color")
    private String color;
}

