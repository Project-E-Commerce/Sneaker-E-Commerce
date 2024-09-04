package E_commerce.Sneaker.controller;

import E_commerce.Sneaker.Service.Category.CategoryService;
import E_commerce.Sneaker.Service.Product.ProductService;
import E_commerce.Sneaker.model.Product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
@RequestMapping(path = "api/v1/product") // router
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    @RequestMapping(method = RequestMethod.POST)
    public Product save(@RequestBody Product product){
        try {
            if (product.getProduct_id()>0){
                product.setUpdate_at(new Date());
                product = productService.updateOne(product);
            }else {
                product.setCreated_at(new Date());
                product = productService.insertOne(product);
            }
            return product;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
