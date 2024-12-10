package E_commerce.Sneaker.Service.ProductInfo;

import E_commerce.Sneaker.model.ProductInfo.ProductColor;
import E_commerce.Sneaker.repository.ProductColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductColorImpl implements ProductColorService{
    @Autowired
    ProductColorRepository productColorRepository;

    @Override
    public List<ProductColor> findAll() {
        return productColorRepository.findAll();
    }

    @Override
    public ProductColor insertOne(ProductColor productColor) {
        return productColorRepository.save(productColor);
    }

    @Override
    public boolean deleteOne(Long id) {
        ProductColor productColor = productColorRepository.findById(id).get();
        if (productColor != null){
            productColorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
