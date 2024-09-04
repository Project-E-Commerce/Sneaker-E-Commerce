package E_commerce.Sneaker.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductFilterDTO {
    private Long category_id;
    private List<String> list_size;
    private String price_sort;
}
