package com.isbasi.Service;

import com.isbasi.Repository.EmailRepository;
import com.isbasi.dto.EmailDto;
import com.isbasi.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {
    @Autowired
    EmailRepository emailRepository;
    public EmailDto createEmail(EmailDto emailRequest) {
        return emailRepository.save(emailRequest);
    }

    public List<EmailDto> getAllEmails() {
        return emailRepository.findAll();
    }

    public EmailDto getEmailById(int id) {
        return emailRepository.findById(id).orElseThrow();
    }

    public EmailDto updateEmail(int id, EmailDto emailRequest) {
        EmailDto foundEmail = emailRepository.findById(id).orElseThrow();

        foundEmail.setTo(emailRequest.getTo());
        foundEmail.setTitle(emailRequest.getTitle());
        foundEmail.setEmail(emailRequest.getEmail());

        return emailRepository.save(foundEmail);
    }

    public String deleteEmail(int id) {
        emailRepository.deleteById(id);

        return id + " id'li email silindi.";
    }
}
