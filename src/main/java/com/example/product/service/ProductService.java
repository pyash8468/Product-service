package com.example.product.service;

import com.example.product.bean.Product;
import com.example.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    @Autowired
   private final ProductRepository productRepo;

    public ProductService(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    //getting all products
    public List<Product> getAllProducts(){
     return   productRepo.findAll();
    }


//getting one product by it's ID
    public Product getProductById(int product_id){
        return   productRepo.findById(product_id).get();
    }

//adding new product
    public Product addProduct(Product product){
           product.setProduct_id(maxId());
           productRepo.save(product);
           return product;
    }
//Generating Id
    public int maxId(){
      return   productRepo.findAll().size() +1;
    }

//updating a product
    public Product updateProduct(Product product){
       productRepo.save(product);
       return product;
    }

//deleting a product
public String deleteProduct(int product_id){
  productRepo.deleteById(product_id);
  return "Product "+product_id+" deleted";
}

}
