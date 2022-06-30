package com.logo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicInteger;


public class Product {
    private static final AtomicInteger i = new AtomicInteger(0);
    private int id;
    private String productCode;
    private String name;
    private Double unitPrice;
    private Double kdv;
    private Double totalPrice;
    private int stock;

    public Product(String productCode, String name, Double unitPrice, Double kdv, int stock) {
        id = i.incrementAndGet();
        this.productCode = productCode;
        this.name = name;
        this.unitPrice = unitPrice;
        this.kdv = kdv;
        this.stock = stock;
        totalPrice = unitPrice + (unitPrice*kdv/100);
    }






    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getKdv() {
        return kdv;
    }

    public void setKdv(Double kdv) {
        this.kdv = kdv;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
