package com.logo.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void sendEmail(String email) {
		rabbitTemplate.convertAndSend("isbasi.email", "", email);
	}

}
