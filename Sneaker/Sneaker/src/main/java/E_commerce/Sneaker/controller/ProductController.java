package E_commerce.Sneaker.controller;

import E_commerce.Sneaker.Service.Product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/product")
public class ProductController {
    @Autowired
    ProductService productService;
}
