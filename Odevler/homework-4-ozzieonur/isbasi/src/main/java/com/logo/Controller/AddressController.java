package com.logo.Controller;

import com.logo.Model.Address;
import com.logo.Model.Customer;
import com.logo.Service.AddressService;
import com.logo.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping
    public Address createAddress(@RequestBody Address addressRequest) {
        return addressService.createAddress(addressRequest);

    }

    @GetMapping
    public List<Address> getAllAddress() { // Tüm müşterileri getiren endpoint
        return addressService.getAllAddress();
    }



    @GetMapping("/{id}")
    public Address getAddressById(@PathVariable int id) { // ID'e göre müşteriyi getiren endpoint
        return addressService.getAddressById(id);
    }

    @PutMapping("/{id}")
    public Address updateAddress(@PathVariable int id, @RequestBody Address addressRequest){
        return addressService.updateAddress(id,addressRequest);
    }


    @DeleteMapping("/{id}")
    public String deleteAddress(@PathVariable int id){ // ID'e göre müşteriyi silen endpoint
        return addressService.deleteAddress(id);
    }
}
