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

import java.util.*;
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
            List<ProductDTO> listDTO = getList().stream()
                    .filter(x -> x.getCategory_id() != null &&
                            x.getCategory_id().equals(productFilterDTO.getCategory_id()))
                    .collect(Collectors.toList());


            // Lọc theo list_color
            if (productFilterDTO.getList_color() != null && !productFilterDTO.getList_color().isEmpty()) {
                Set<Long> listIdProductColor = listProductColor.stream()
                        .filter(c -> productFilterDTO.getList_color().contains(c.getColor()))
                        .map(ProductColor::getProduct_id)
                        .collect(Collectors.toSet());

                listDTO = listDTO.stream()
                        .filter(p -> listIdProductColor.contains(p.getProduct_id()))
                        .collect(Collectors.toList());
            }

            // Lọc theo kích thước
            if (productFilterDTO.getList_size() != null && !productFilterDTO.getList_size().isEmpty()) {
                Set<String> filterSizes = new HashSet<>(productFilterDTO.getList_size());

                listDTO = listDTO.stream()
                        .filter(pDTO -> {
                            List<String> productSizes = Arrays.asList(pDTO.getSize().split(","));
                            return productSizes.stream().anyMatch(filterSizes::contains);
                        })
                        .collect(Collectors.toList());
            }
            // Sắp xếp theo price
            if (productFilterDTO.getPrice_sort() != null) {
                if (productFilterDTO.getPrice_sort().equalsIgnoreCase("asc")) {
                    listDTO = listDTO.stream()
                            .sorted(Comparator.comparing(ProductDTO::getPrice))
                            .collect(Collectors.toList());
                } else if (productFilterDTO.getPrice_sort().equalsIgnoreCase("desc")) {
                    listDTO = listDTO.stream()
                            .sorted(Comparator.comparing(ProductDTO::getPrice).reversed())
                            .collect(Collectors.toList());
                }
            }

            return listDTO;
        } catch (Exception e) {
            System.out.println( "Error filtering products: " + e.getMessage());
            return Collections.emptyList();
        }
    }
}
