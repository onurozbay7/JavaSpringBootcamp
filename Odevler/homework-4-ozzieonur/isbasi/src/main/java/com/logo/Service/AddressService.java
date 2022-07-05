package com.logo.Service;

import com.logo.Model.Address;
import com.logo.Model.Customer;
import com.logo.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;
    public Address createAddress(Address addressRequest) {
        return addressRepository.save(addressRequest);
    }



    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    public Address getAddressById(int id) {
        return addressRepository.findById(id).orElseThrow();
    }

    public String deleteAddress(int id) {
        addressRepository.deleteById(id);

        return id + " id'li address silindi";
    }

    public Address updateAddress(int id, Address addressRequest) {
        Address foundAddress = addressRepository.findById(id).orElseThrow();
        foundAddress.setCountry(addressRequest.getCountry());
        foundAddress.setProvince(addressRequest.getProvince());
        foundAddress.setAddress(addressRequest.getAddress());

        return addressRepository.save(foundAddress);
    }
}
