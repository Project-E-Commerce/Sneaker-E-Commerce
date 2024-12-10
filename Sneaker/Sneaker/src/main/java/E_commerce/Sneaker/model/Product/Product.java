package E_commerce.Sneaker.model.Product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "product")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false )
    private Long product_id;
    @Column(name ="product_name" )
    private String product_name;
    @Column(name = "size")
    private String size;
    @Column(name = "category_id")
    private Long category_id;
    @Column(name ="price" )
    private double price;
    @Column(name = "created_at")
    @CreationTimestamp
    private Date created_at;
    @Column(name = "update_at")
    @UpdateTimestamp
    private Date update_at;

    @Column(name = "deleted_at")
    @UpdateTimestamp
    private Date deleted_at;
}
