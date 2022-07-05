package com.logo.Service;

import com.logo.Dto.EmailDto;
import com.logo.Model.Customer;
import com.logo.Model.User;
import com.logo.Repository.AddressRepository;
import com.logo.Repository.CustomerRepository;
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

    @Autowired
    private CustomerRepository customerRepository;

    public User createUser(User request) {

         rabbitTemplate.convertAndSend("isbasi.email", new EmailDto(request.getEmail(), "EmailService" ,"Test Başarılı"));


        userRepository.save(request);
        customerRepository.saveAll(request.getCustomerList());

        return request;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User findById(int id) {
        return userRepository.findById(id).orElseThrow();
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow();
    }

    public User deleteById(int id) {
        User foundUser = userRepository.findById(id).orElseThrow();

        userRepository.delete(foundUser);

        return foundUser;
    }


    public User updateUser(int id, User userRequest) {
        User foundUser = userRepository.findById(id).orElseThrow();

        foundUser.setName(userRequest.getName());
        foundUser.setSurname(userRequest.getSurname());
        foundUser.setEmail(userRequest.getEmail());
        foundUser.setPassword(userRequest.getPassword());
        foundUser.setAddress(userRequest.getAddress());
        return userRepository.save(foundUser);
    }
}
