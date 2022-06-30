package com.logo.Repository;


import com.logo.Model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Repository

public class ProductRepository {

    static List<Product> productList = new ArrayList<>(10);

    public Product create(Product productRequest) {
        productList.add(productRequest);

        return productRequest;
    }

    public List<Product> findAll() {
        return productList;
    }

    public Product findById(int id) {
       return productList.stream().filter(product -> product.getId() == id).findFirst().orElseThrow();
    }

    public Product update(int id, Product productRequest) {
        Product product =  productList.stream().filter(product1 -> product1.getId() == id).findFirst().orElseThrow();

        product.setProductCode(productRequest.getProductCode());
        product.setName(productRequest.getName());
        product.setUnitPrice(productRequest.getUnitPrice());
        product.setKdv(productRequest.getKdv());
        product.setStock(productRequest.getStock());
        product.setTotalPrice(productRequest.getUnitPrice() + (productRequest.getUnitPrice() * productRequest.getKdv()/100));

        return product;
    }

    public Product delete(int id) {

        Product product = productList.stream().filter(product1 -> product1.getId() == id).findFirst().orElseThrow();
        productList.remove(product);

        return product;
    }
}
