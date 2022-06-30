package com.logo.Model;

import com.logo.Model.enums.CustomerType;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class User {
    private String name;
    private String surname;
    private String email;
    private String password;
    private Adress adress;
    private List<Customer> customerList = new ArrayList<>(10);
}
