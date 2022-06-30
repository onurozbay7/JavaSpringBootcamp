package com.isbasi.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmailListener {
	
	@RabbitListener(queues = "isbasi.email")
	public void emailListener(String email) {
		log.info("email address: {}", email);	
		// TO DO mail at
	}

}
