package com.logo.Repository;
import com.logo.Model.Customer;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {


    List<Customer> findByStatus(boolean status);
}
