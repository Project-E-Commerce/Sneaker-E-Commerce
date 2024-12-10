package E_commerce.Sneaker.Service.ProductInfo;

import E_commerce.Sneaker.model.ProductInfo.ProductImage;
import E_commerce.Sneaker.repository.ProductImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImageImpl implements ProductImageService {
    @Autowired
    ProductImageRepository productImageRepository;

    @Override
    public List<ProductImage> findAll() {
        return productImageRepository.findAll();
    }

    @Override
    public ProductImage insertOne(ProductImage productImage) {
        return productImageRepository.save(productImage);
    }

    @Override
    public boolean deleteOne(Long id) {
        ProductImage productImage = productImageRepository.findById(id).get();
        if (productImage != null){
            productImageRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
