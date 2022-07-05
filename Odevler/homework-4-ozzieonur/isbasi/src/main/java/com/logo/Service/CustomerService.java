package com.logo.Service;


import com.logo.Model.Customer;
import com.logo.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Customer foundCustomer = customerRepository.findById(id).orElseThrow();
        foundCustomer.setName(customerRequest.getName());
        foundCustomer.setAge(customerRequest.getAge());
        foundCustomer.setStatus(customerRequest.isStatus());
        foundCustomer.setCustomerType(customerRequest.getCustomerType());
        return customerRepository.save(foundCustomer);
    }

    public String deleteCustomer(int id) {
        customerRepository.deleteById(id);

        return id + " id'li müşteri silindi.";
    }

    public List<Customer> getCustomersByStatus(boolean status) {
       return customerRepository.findByStatus(status);
    }

    public Customer getCustomerById(int id) {
        return customerRepository.findById(id).orElseThrow();
    }
}
