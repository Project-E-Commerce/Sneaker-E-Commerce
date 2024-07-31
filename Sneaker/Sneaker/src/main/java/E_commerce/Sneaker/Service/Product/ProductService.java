package E_commerce.Sneaker.Service.Product;

import E_commerce.Sneaker.model.Product.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product updateOne(Product product);
    Product insertOne(Product product);
    Product findById(Long id);
    boolean deleteOne(Long id);
}
