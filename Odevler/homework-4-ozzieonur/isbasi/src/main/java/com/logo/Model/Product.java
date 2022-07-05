package com.logo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String productCode;
    private String name;
    private Double unitPrice;
    private Double kdv;
    private Double totalPrice;
    private int stock;

    public Product(int id, String productCode, String name, Double unitPrice, Double kdv, int stock) {
        this.id = id;
        this.productCode = productCode;
        this.name = name;
        this.unitPrice = unitPrice;
        this.kdv = kdv;
        this.stock = stock;
        this.totalPrice = unitPrice + (unitPrice * kdv / 100);
    }
}
