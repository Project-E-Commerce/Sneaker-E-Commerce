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
import org.springframework.http.ResponseEntity;
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

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getList() {
        try {
            List<Product> products = productService.findAll();
            List<ProductDTO> productDTOs = new ArrayList<>();

            for (Product product : products) {
                Category category = categoryService.findById(product.getCategory_id());
                ProductDTO productDTO = new ProductDTO();
                productDTO.setProduct_id(product.getProduct_id());
                productDTO.setPrice(product.getPrice());
                productDTO.setCategory_id(product.getCategory_id());
                productDTO.setCreated_at(product.getCreated_at());
                productDTO.setDeleted_at(product.getDeleted_at());
                productDTO.setProduct_name(product.getProduct_name());
                productDTO.setUpdate_at(product.getUpdate_at());
                productDTO.setCategory_name(category != null ? category.getCategory_name() : null);
                productDTO.setSize(product.getSize());
                productDTOs.add(productDTO);
            }

            return ResponseEntity.ok(productDTOs);
        } catch (Exception e) {
            System.err.println("Error fetching products: " + e.getMessage());
            return ResponseEntity.status(500).body(Collections.emptyList());
        }
    }


    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product) {
        try {
            if (product.getProduct_id() > 0) {
                product.setUpdate_at(new Date());
                return ResponseEntity.ok(productService.updateOne(product));
            } else {
                product.setCreated_at(new Date());
                return ResponseEntity.ok(productService.insertOne(product));
            }
        } catch (Exception e) {
            System.err.println("Error saving product: " + e.getMessage());
            return ResponseEntity.status(500).body(null);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        try {
            boolean result = productService.deleteOne(id);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            System.err.println("Error deleting product: " + e.getMessage());
            return ResponseEntity.status(500).body(false);
        }
    }

    @PostMapping(path = "/filter")
    public ResponseEntity<List<ProductDTO>> filterProduct(@RequestBody ProductFilterDTO productFilterDTO) {
        try {
            List<Product> products = productService.findAll();
            List<ProductColor> productColors = productColorService.findAll();
            List<ProductDTO> productDTOs = new ArrayList<>();

            for (Product product : products) {
                Category category = categoryService.findById(product.getCategory_id());
                ProductDTO productDTO = new ProductDTO();
                productDTO.setProduct_id(product.getProduct_id());
                productDTO.setPrice(product.getPrice());
                productDTO.setCategory_id(product.getCategory_id());
                productDTO.setCreated_at(product.getCreated_at());
                productDTO.setDeleted_at(product.getDeleted_at());
                productDTO.setProduct_name(product.getProduct_name());
                productDTO.setUpdate_at(product.getUpdate_at());
                productDTO.setCategory_name(category != null ? category.getCategory_name() : null);
                productDTO.setSize(product.getSize());
                productDTOs.add(productDTO);
            }

            List<ProductDTO> filteredProducts = new ArrayList<>();

            for (ProductDTO productDTO : productDTOs) {
                if (productDTO.getCategory_id() != null &&
                        productDTO.getCategory_id().equals(productFilterDTO.getCategory_id())) {
                    filteredProducts.add(productDTO);
                }
            }

            if (productFilterDTO.getList_color() != null && !productFilterDTO.getList_color().isEmpty()) {
                Set<Long> filteredColorIds = new HashSet<>();

                for (ProductColor productColor : productColors) {
                    if (productFilterDTO.getList_color().contains(productColor.getColor())) {
                        filteredColorIds.add(productColor.getProduct_id());
                    }
                }

                filteredProducts.removeIf(productDTO -> !filteredColorIds.contains(productDTO.getProduct_id()));
            }

            if (productFilterDTO.getList_size() != null && !productFilterDTO.getList_size().isEmpty()) {
                Set<String> filterSizes = new HashSet<>(productFilterDTO.getList_size());

                filteredProducts.removeIf(productDTO -> {
                    List<String> productSizes = Arrays.asList(productDTO.getSize().split(","));
                    return productSizes.stream().noneMatch(filterSizes::contains);
                });
            }

            if (productFilterDTO.getPrice_sort() != null) {
                filteredProducts.sort((p1, p2) -> {
                    if (productFilterDTO.getPrice_sort().equalsIgnoreCase("asc")) {
                        return Double.compare(p1.getPrice(), p2.getPrice());
                    } else {
                        return Double.compare(p2.getPrice(), p1.getPrice());
                    }
                });
            }

            return ResponseEntity.ok(filteredProducts);
        } catch (Exception e) {
            System.err.println("Error filtering products: " + e.getMessage());
            return ResponseEntity.status(500).body(Collections.emptyList());
        }
    }
}