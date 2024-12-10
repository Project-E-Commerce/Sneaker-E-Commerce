package E_commerce.Sneaker.controller;

import E_commerce.Sneaker.Service.Category.CategoryService;
import E_commerce.Sneaker.Service.Product.ProductService;
import E_commerce.Sneaker.Service.ProductInfo.ProductColorService;
import E_commerce.Sneaker.dtos.ProductDTO;
import E_commerce.Sneaker.dtos.ProductFilterDTO;
import E_commerce.Sneaker.model.Category.Category;
import E_commerce.Sneaker.model.Product.Product;
import E_commerce.Sneaker.model.ProductInfo.ProductColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/product") // router
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductColorService productColorService;

    @RequestMapping(method = RequestMethod.GET)
    public List<ProductDTO> getList(){
        try{
            List<Product> list = productService.findAll();
            var listDTO = new ArrayList<ProductDTO>();

            for (Product p : list){
                Category category = categoryService.findById(p.getCategory_id());
                ProductDTO proDTO = new ProductDTO();
                proDTO.setProduct_id(p.getProduct_id());
                proDTO.setPrice(p.getPrice());
                proDTO.setCategory_id(p.getCategory_id());
                proDTO.setCreated_at(p.getCreated_at());
                proDTO.setDeleted_at(p.getDeleted_at());
                proDTO.setProduct_name(p.getProduct_name());
                proDTO.setUpdate_at(p.getUpdate_at());
                proDTO.setCategory_name(category.getCategory_name());
                proDTO.setSize(p.getSize());
                listDTO.add(proDTO);
            }
            return listDTO;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

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
    @RequestMapping(method = RequestMethod.POST, path = "/{id}")
    public boolean delete(@PathVariable Long id){
        try {
            Boolean rs = false;
            if (productService.deleteOne(id)) {
                rs = true;
            }
            return rs;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    @RequestMapping(method = RequestMethod.POST, path = "/filter")
    public List<ProductDTO> filterProduct(@RequestBody ProductFilterDTO productFilterDTO){
        try{
            System.out.println(productFilterDTO.getCategory_id());
            List<ProductColor> listProductColor = productColorService.findAll();

            var listDTO  = getList().stream().filter(x -> x.getCategory_id() == productFilterDTO.getCategory_id()).collect(Collectors.toList());
//            if (productFilterDTO.getList_color().size() > 0) {
//                var listColorFilter = listProductColor.stream().filter(c -> productFilterDTO.getList_color().contains(c.getColor())).collect(Collectors.toList());
//                var listIdProductColor = listColorFilter.stream().map(c -> c.getProduct_id()).collect(Collectors.toList());
//                listDTO = listDTO.stream().filter(p -> listIdProductColor.contains(p.getProduct_id())).collect(Collectors.toList());
//            }
//            if (productFilterDTO.getList_size().size() > 0) {
//                for (ProductDTO pDTO : listDTO) {
//                    pDTO.setList_size(Arrays.stream(pDTO.getSize().split(",", 0)).collect(Collectors.toList()));
//                }
//                for (ProductDTO pDTO : listDTO) {
//                    for (var size: pDTO.getList_size()) {
//                        if (!productFilterDTO.getList_size().contains(size)) {
//                            listDTO = listDTO.stream().filter(o -> o.getProduct_id() != pDTO.getProduct_id()).collect(Collectors.toList());
//                        }
//                    }
//                }
//            }

            return listDTO;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
