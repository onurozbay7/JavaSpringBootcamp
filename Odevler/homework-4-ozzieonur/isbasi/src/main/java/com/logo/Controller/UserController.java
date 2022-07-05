package com.logo.Controller;

import com.logo.Model.Customer;
import com.logo.Model.User;
import com.logo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User userRequest) { // Sisteme kullanıcı ekleyen endpoint
        return userService.createUser(userRequest);
    }

    @GetMapping
    public List<User> getAllUsers() { // Tüm kullanıcıları getiren endpoint
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id){
        return userService.findById(id);
    }

    @GetMapping("/email/{email}")
    public User getUserByEmail(@PathVariable String email){ // Email'e göre kullanıcı getiren endpoint
        return userService.getUserByEmail(email);
    }

    /*@GetMapping("/{email}/customers")
    public List<Customer> getCustomersUserByEmail(@PathVariable String email){ // Kullanıcının müşterilerini getiren endpoint
        return userService.getCustomersByEmail(email);
    }*/

    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User userRequest){
        return userService.updateUser(id,userRequest);
    }

    @DeleteMapping("/{id}")
    public User deleteUser(@PathVariable int id){
       return userService.deleteById(id);
    }
}
