package E_commerce.Sneaker.controller;

import E_commerce.Sneaker.Service.Category.CategoryService;
import E_commerce.Sneaker.model.Category.Category;
import E_commerce.Sneaker.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/category") // router
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Category> getList(){
        try {
            List<Category> list = categoryService.findAll();
            return list;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    @RequestMapping(method = RequestMethod.POST)
    public Category save(@RequestBody Category category){
        try {
            if (category.getCategory_id() >0){
                category.setUpdate_at(new Date());
                category = categoryService.updateOne(category);
            }else {
                category.setCreated_at(new Date());
                category = categoryService.insertOne(category);
            }
            return category;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public boolean delete(@PathVariable Long id){
        try{
            Boolean a = false;
            if (categoryService.deleteOne(id)){
                a = true;
            }
            return a;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
