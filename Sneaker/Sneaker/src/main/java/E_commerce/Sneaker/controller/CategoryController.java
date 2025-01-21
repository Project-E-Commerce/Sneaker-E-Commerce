package E_commerce.Sneaker.controller;

import E_commerce.Sneaker.Service.Category.CategoryService;
import E_commerce.Sneaker.model.Category.Category;
import E_commerce.Sneaker.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/category") // router
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getList() {
        try {
            List<Category> list = categoryService.findAll();
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            System.err.println("Error fetching categories: " + e.getMessage());
            return ResponseEntity.status(500).body(null);
        }
    }
    @PostMapping
    public ResponseEntity<Category> save(@RequestBody Category category) {
        try {
            if (category.getCategory_id() > 0) {
                category.setUpdate_at(new Date());
                category = categoryService.updateOne(category);
            } else {
                category.setCreated_at(new Date());
                category = categoryService.insertOne(category);
            }
            return ResponseEntity.ok(category);
        } catch (Exception e) {
            System.err.println("Error saving category: " + e.getMessage());
            return ResponseEntity.status(500).body(null);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        try {
            boolean result = categoryService.deleteOne(id);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            System.err.println("Error deleting category: " + e.getMessage());
            return ResponseEntity.status(500).body(false);
        }
    }
}
