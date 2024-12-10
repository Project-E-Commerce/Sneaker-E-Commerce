package E_commerce.Sneaker.Service.ProductInfo;

import E_commerce.Sneaker.model.ProductInfo.ProductColor;

import java.util.List;

public interface ProductColorService {
    List<ProductColor> findAll();
    ProductColor insertOne(ProductColor productColor);
    boolean deleteOne(Long id);
}
