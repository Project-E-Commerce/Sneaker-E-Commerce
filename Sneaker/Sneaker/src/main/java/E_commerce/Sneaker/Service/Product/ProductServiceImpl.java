package E_commerce.Sneaker.Service.Product;

import E_commerce.Sneaker.model.Product.Product;
import E_commerce.Sneaker.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> findAll(){
        return productRepository.findAll();
    }
    @Override
    public Product updateOne(Product product){
        return productRepository.save(product);
    }
    @Override
    public Product insertOne(Product product){
        return productRepository.save(product);
    }
    @Override
    public Product findById(Long id){
        return productRepository.findById(id).get();
    }
    @Override
    public boolean deleteOne(Long id){
        Product a = findById(id);
        if (a != null){
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
