package E_commerce.Sneaker.Service.ProductInfo;

import E_commerce.Sneaker.model.ProductInfo.ProductDetail;
import E_commerce.Sneaker.repository.ProductDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDetailImpl implements ProductDetailService {
    @Autowired
    ProductDetailRepository productDetailRepository;
    @Override
    public List<ProductDetail> findALl() {
        return productDetailRepository.findAll();
    }

    @Override
    public ProductDetail insertOne(ProductDetail productDetail) {
        return productDetailRepository.save(productDetail);
    }

    @Override
    public boolean deleteOne(Long id) {
        ProductDetail productDetail = productDetailRepository.findById(id).get();
        if (productDetail != null){
            productDetailRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
