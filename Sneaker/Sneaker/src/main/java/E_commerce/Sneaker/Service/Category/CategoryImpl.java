package E_commerce.Sneaker.Service.Category;

import E_commerce.Sneaker.model.Category.Category;
import E_commerce.Sneaker.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryImpl implements CategoryService{
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll(){
        return categoryRepository.findAll();
    }
    @Override
    public Category updateOne(Category category){
        return categoryRepository.save(category);
    }
    @Override
    public Category insertOne(Category category){
        return categoryRepository.save(category);
    }
    @Override
    public Category findById(Long id){
        return categoryRepository.findById(id).get();
    }
    @Override
    public boolean deleteOne(Long id){
        Category category = findById(id);
        if (category != null){
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
