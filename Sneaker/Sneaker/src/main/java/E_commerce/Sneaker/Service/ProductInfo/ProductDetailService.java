package E_commerce.Sneaker.Service.ProductInfo;

import E_commerce.Sneaker.model.ProductInfo.ProductDetail;

import java.util.List;

public interface ProductDetailService {
    List<ProductDetail> findALl();
    ProductDetail insertOne(ProductDetail productDetail);
    boolean deleteOne(Long id);
}
