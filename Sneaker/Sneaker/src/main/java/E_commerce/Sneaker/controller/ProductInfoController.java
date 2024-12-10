package E_commerce.Sneaker.controller;


import E_commerce.Sneaker.Service.ProductInfo.ProductColorService;
import E_commerce.Sneaker.Service.ProductInfo.ProductDetailService;
import E_commerce.Sneaker.Service.ProductInfo.ProductImageService;
import E_commerce.Sneaker.model.ProductInfo.ProductColor;
import E_commerce.Sneaker.model.ProductInfo.ProductDetail;
import E_commerce.Sneaker.model.ProductInfo.ProductImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/product/info")
public class ProductInfoController {
    @Autowired
    ProductColorService productColorService;
    @Autowired
    ProductImageService productImageService;
    @Autowired
    ProductDetailService productDetailService;

    @RequestMapping(method = RequestMethod.GET, path = "/color")
    public List<ProductColor> getListColor(){
        try {
            List<ProductColor> list = productColorService.findAll();
            return list;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/detail")
    public List<ProductDetail> getListDetail(){
        try {
            List<ProductDetail> list = productDetailService.findALl();
            return list;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @RequestMapping(method = RequestMethod.GET, path = "/image")
    public List<ProductImage> getListImage(){
        try {
            List<ProductImage> list = productImageService.findAll();
            return list;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @RequestMapping(method = RequestMethod.POST, path = "/color")
    public ProductColor insertColor(@RequestBody ProductColor productColor) {
        try {
            productColor = productColorService.insertOne(productColor);
            return productColor;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.POST, path = "/detail")
    public ProductDetail insertDetail(@RequestBody ProductDetail productDetail) {
        try {
            productDetail = productDetailService.insertOne(productDetail);
            return productDetail;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.POST, path = "/image")
    public ProductImage insertImage(@RequestBody ProductImage productImage) {
        try {
            productImage = productImageService.insertOne(productImage);
            return productImage;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/color/{id}")
    public boolean deleteColor(@PathVariable Long id) {
        try {
            Boolean delete = false;
            if (productColorService.deleteOne(id)) {
                delete = true;
            }
            return delete;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/detail/{id}")
    public boolean deleteDetail(@PathVariable Long id) {
        try {
            Boolean delete = false;
            if (productDetailService.deleteOne(id)) {
                delete = true;
            }
            return delete;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/image/{id}")
    public boolean deleteImage(@PathVariable Long id) {
        try {
            Boolean delete = false;
            if (productImageService.deleteOne(id)) {
                delete = true;
            }
            return delete;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
