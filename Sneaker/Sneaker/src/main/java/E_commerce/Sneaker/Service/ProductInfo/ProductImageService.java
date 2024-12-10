package E_commerce.Sneaker.Service.ProductInfo;

import E_commerce.Sneaker.model.ProductInfo.ProductImage;

import java.util.List;

public interface ProductImageService {
    List<ProductImage> findAll();
    ProductImage insertOne(ProductImage productImage);
    boolean deleteOne(Long id);
}
