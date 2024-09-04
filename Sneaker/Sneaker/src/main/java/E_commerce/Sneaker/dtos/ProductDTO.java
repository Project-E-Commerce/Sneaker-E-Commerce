package E_commerce.Sneaker.dtos;

import E_commerce.Sneaker.model.Product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDTO extends Product {
    private String category_name;
    private List<String> list_size;
}
