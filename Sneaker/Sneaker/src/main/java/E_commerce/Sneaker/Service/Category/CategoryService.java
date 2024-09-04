package E_commerce.Sneaker.Service.Category;

import E_commerce.Sneaker.model.Category.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category updateOne(Category category);
    Category insertOne(Category category);
    Category findById(Long id);
    boolean deleteOne(Long id);
}
