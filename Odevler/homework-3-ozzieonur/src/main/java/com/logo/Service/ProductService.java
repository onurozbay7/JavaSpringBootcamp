package com.logo.Service;


import com.logo.Model.Product;
import com.logo.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    public Product createProduct(Product productRequest) {
        return productRepository.create(productRequest);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
        return productRepository.findById(id);
    }

    public Product updateProduct(int id,Product productRequest) {
       return productRepository.update(id,productRequest);
    }

    public Product deleteProduct(int id) {
        return productRepository.delete(id);
    }
}
