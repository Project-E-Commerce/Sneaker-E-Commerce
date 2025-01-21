package E_commerce.Sneaker.model.Order;

import E_commerce.Sneaker.model.Product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="order_id", nullable = false)
    private Long order_id;
    private String name;
    @Column(name = "address")
    private String address;
    @ManyToMany
    @JoinTable(
            name = "order",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> product;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "phone")
    private String phone;
    @Column(name = "number", nullable = false)
    private int number;
    @Column(name = "address_from")
    private String address_from;
    @Column(name = "address_to")
    private String address_to;
    @Column(name = "created_at")
    @CreationTimestamp
    private Date created_at;

    @Column(name = "update_at")
    @UpdateTimestamp
    private Date update_at;

    @Column(name = "deleted_at")
    @UpdateTimestamp
    private Date deleted_at;

    @Override
    public String toString() {
        return  ", user_Id=" + userId +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'';
    }
}
