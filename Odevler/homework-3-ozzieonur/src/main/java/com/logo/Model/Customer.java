package com.logo.Model;

import com.logo.Model.enums.CustomerType;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;



public class Customer {

    private static final AtomicInteger i = new AtomicInteger(0);



    private int id;
    private String name;
    private int age;
    private boolean isActive;

    private CustomerType customerType;


    public void setId(int id) {
        this.id = id;
    }

    private List<Invoice> invoiceList;

    public Customer() {
        id = i.incrementAndGet();
    }

    public Customer(int id, String name, int age,boolean isActive , CustomerType customerType , List<Invoice> invoiceList) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.isActive = isActive;
        this.customerType = customerType;
        this.invoiceList = invoiceList;
    }



    public Customer(String name, int age, boolean isActive, CustomerType customerType, List<Invoice> invoiceList) {
        id = i.incrementAndGet();
        this.name = name;
        this.age = age;
        this.isActive = isActive;
        this.customerType = customerType;
        this.invoiceList = invoiceList;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }
}
