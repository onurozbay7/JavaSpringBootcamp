package com.isbasi.listener;

import com.isbasi.Repository.EmailRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isbasi.dto.EmailDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmailListener {

	@Autowired
	EmailRepository emailRepository;

	@RabbitListener(queues = "isbasi.email")
	public void emailListener(EmailDto emailDto) {
		log.info("email address: {}", emailDto.getEmail());

		emailRepository.save(emailDto); // MongoDB veritabanına kaydeden method.
		// TO DO mail at
	}

}
