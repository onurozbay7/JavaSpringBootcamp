package com.logo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.logo.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
