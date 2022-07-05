package com.logo.Controller;


import com.logo.Model.Product;
import com.logo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public Product createProduct(@RequestBody Product productRequest){
        return productService.createProduct(productRequest);
    }

    @GetMapping
    public List<Product> getAllProducts(){
       return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id){
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product productRequest){
        return productService.updateProduct(id,productRequest);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id){
       return productService.deleteProduct(id);
    }


}
