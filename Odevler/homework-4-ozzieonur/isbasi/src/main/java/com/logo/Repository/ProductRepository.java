package com.logo.Repository;


import com.logo.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Repository

public interface ProductRepository extends JpaRepository<Product, Integer> {


}
