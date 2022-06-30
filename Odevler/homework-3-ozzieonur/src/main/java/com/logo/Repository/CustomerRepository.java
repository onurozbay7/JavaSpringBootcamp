package com.logo.Repository;

import com.logo.Model.Customer;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Data
public class CustomerRepository {
    private static List<Customer> customerList = new ArrayList<>();



    public Customer save(Customer customerRequest) {
        customerList.add(customerRequest);

        return customerRequest;

    }

    public List<Customer> findAll() {
        return customerList;
    }

    public Customer update(int id, Customer customerRequest) { // 1. yol = customerList üzerinden set yapma işlemi ile update atma.
                                                               // 2.yol için Invoice Repository -> update metoduna bakabilirsiniz.

        int indexOf = customerList.indexOf(customerList.stream().filter(customer -> customer.getId() == id).findFirst().orElseThrow());

        customerRequest.setId(id);
        customerList.set(indexOf, customerRequest);

        return customerRequest;


    }

    public Customer remove(int id) {
        Customer customer1 = customerList.stream()
                .filter(customer -> customer.getId() == id)
                .findFirst().orElseThrow();
        customerList.remove(customer1);
        return customer1;
    }

    public List<Customer> findByState(boolean isActive) {
      return customerList.stream().filter(isActive ? Customer::getIsActive : customer -> !customer.getIsActive()).toList();
    }

    public Customer findById(int id) {

        return customerList.stream().filter(customer -> customer.getId() == id).findFirst().orElseThrow();
    }
}
