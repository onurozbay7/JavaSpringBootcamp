package com.logo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logo.model.Customer;
import com.logo.model.User;
import com.logo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RabbitMQService rabbitMQService;
	
	@Autowired
	private AmqpTemplate rabbitTemplate;

	public User createUser(User request) {
				
		rabbitTemplate.convertAndSend("isbasi.email", request.getEmail());
		
		//rabbitMQService.sendEmail(request.getEmail());
		
		return userRepository.save(request);
	}

	public List<User> getAllUsers() {

		return userRepository.findAll();
	}

	public User getUserByEmail(String email) {
		//kullanıcı bulunamadığında hata verilmeli
		
		userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException());
		
		//userRepository.findByEmail(email).orElseThrow(RuntimeException::new);

		boolean isPresent = userRepository.findByEmail(email).isPresent();
		if (isPresent) {
			return userRepository.findByEmail(email).get();
		}
		// null dönme
		return null;

	}

	public List<Customer> getCustomersByEmail(String email) {
		Optional<User> foundUser = userRepository.findByEmail(email);

		if (foundUser.isPresent()) {
			return foundUser.get().getCustomerList();
		}

		return null;
	}

}
