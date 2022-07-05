package com.logo.Repository;

import com.logo.Model.Customer;
import com.logo.Model.User;
import com.logo.Model.enums.CustomerType;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);



}
