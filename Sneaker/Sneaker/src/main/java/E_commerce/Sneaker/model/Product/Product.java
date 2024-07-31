package E_commerce.Sneaker.model.Product;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;


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
    private int size;
    @Column(name = "category_id")
    private Long category_id;
    @Column(name ="price" )
    private double price;
    @Column(name ="desc")
    private String desc;
    @Column(name = "image")
    private String image;
    @Column(name = "created_at")
    @CreationTimestamp
    private Date created_at;

}
