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
        return productRepository.save(productRequest);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).orElseThrow();
    }

    public Product updateProduct(int id,Product productRequest) {

        Product foundProduct = productRepository.findById(id).orElseThrow();

        foundProduct.setProductCode(productRequest.getProductCode());
        foundProduct.setName(productRequest.getName());
        foundProduct.setUnitPrice(productRequest.getUnitPrice());
        foundProduct.setKdv(productRequest.getKdv());
        foundProduct.setStock(productRequest.getStock());
        foundProduct.setTotalPrice(productRequest.getUnitPrice() + (productRequest.getUnitPrice() * productRequest.getKdv()/100));

       return productRepository.save(foundProduct);
    }

    public String deleteProduct(int id) {
        productRepository.deleteById(id);

        return id + " id'li ürün silindi.";
    }
}
