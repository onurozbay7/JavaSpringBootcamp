package com.logo.Service;

import com.logo.Model.Customer;
import com.logo.Model.User;
import com.logo.Repository.UserRepository;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RabbitMQService rabbitMQService;

    @Autowired
    private AmqpTemplate rabbitTemplate;
    public User createUser(User request) {

        // rabbitTemplate.convertAndSend("isbasi.email", request.getEmail());

        //rabbitMQService.sendEmail(request.getEmail()); // Bu çalışmıyor sebebi sorulacak?

        return userRepository.save(request);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow();
    }

    public List<Customer> getCustomersByEmail(String email) {
        Optional<User> foundUser = userRepository.findByEmail(email);
        return foundUser.map(User::getCustomerList).orElse(null);
    }


}
