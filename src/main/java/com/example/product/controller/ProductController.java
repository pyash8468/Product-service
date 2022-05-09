package com.example.product.controller;

import com.example.product.bean.Product;
import com.example.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<Product> getProducts(){
            return productService.getAllProducts();

    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable(value = "productId") int product_id){
        try{
        Product product=    productService.getProductById(product_id);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
        }catch (Exception e){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @PostMapping("/product")
    public Product newProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @PatchMapping("/product/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "productId") int product_id,@RequestBody Product product){
        try {
         Product existProduct = productService.getProductById(product_id);
         existProduct.setProduct_price(product.getProduct_price());
         existProduct.setProduct_name(product.getProduct_name());
         existProduct.setProduct_description(product.getProduct_description());
         existProduct.setLast_updated_price(product.getLast_updated_price());
        Product updated_product= productService.updateProduct(existProduct);
         return new ResponseEntity<Product>(updated_product, HttpStatus.OK);

     }catch (Exception e){
         return new ResponseEntity<>(HttpStatus.CONFLICT);
     }
    }

    @DeleteMapping("/product/{productId}")
    public String removeProduct(@PathVariable(value = "productId") int product_id){
        return productService.deleteProduct(product_id);
    }

}
