package com.logo.Controller;

import com.logo.Model.Customer;
import com.logo.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customerRequest) { //Müşteri ekleyen endpoint
        return customerService.createCustomer(customerRequest);

    }

    @GetMapping
    public List<Customer> getAllCustomers() { // Tüm müşterileri getiren endpoint
       return customerService.getAllCustomers();
    }

    @GetMapping(value = "/state/{status}")
    public List<Customer> getCustomersByState(@PathVariable("status") boolean status){ // Aktif ve pasif müşterileri getiren endpoint
      return customerService.getCustomersByStatus(status);
    }


    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id) { // ID'e göre müşteriyi getiren endpoint
        return customerService.getCustomerById(id);
    }



    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable int id, @RequestBody Customer customerRequest){ // ID'e göre müşteriyi güncelleyen endpoint
        return customerService.updateCustomer(id,customerRequest);
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable int id){ // ID'e göre müşteriyi silen endpoint
        return customerService.deleteCustomer(id);
    }

}
