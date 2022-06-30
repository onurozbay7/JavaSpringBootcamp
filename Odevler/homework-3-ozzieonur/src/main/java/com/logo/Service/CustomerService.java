package com.logo.Service;


import com.logo.Model.Customer;
import com.logo.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    public Customer createCustomer(Customer customerRequest) {
       return customerRepository.save(customerRequest);
    }

    public List<Customer> getAllCustomers() {
      return  customerRepository.findAll();
    }

    public Customer updateCustomer(int id, Customer customerRequest) {
        return customerRepository.update(id, customerRequest);
    }

    public Customer deleteCustomer(int id) {
        return customerRepository.remove(id);
    }

    public List<Customer> getCustomersByState(boolean isActive) {
       return customerRepository.findByState(isActive);
    }

    public Customer getCustomerById(int id) {
        return customerRepository.findById(id);
    }
}
