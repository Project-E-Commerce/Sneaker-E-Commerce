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
@Table(name = "product_image")
@Entity
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_image_id")
    private Long product_image_id;
    @Column(name = "product_id")
    private Long product_id;
    @Column(name = "image")
    private String image;
}
