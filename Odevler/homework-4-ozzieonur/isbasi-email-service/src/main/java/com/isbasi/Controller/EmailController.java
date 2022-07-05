package com.isbasi.Controller;

import com.isbasi.Service.EmailService;
import com.isbasi.dto.EmailDto;
import com.isbasi.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;


    @PostMapping
    public EmailDto createEmail(@RequestBody EmailDto emailRequest){
        return emailService.createEmail(emailRequest);
    }

    @GetMapping
    public List<EmailDto> getAllEmails(){
        return emailService.getAllEmails();
    }

    @GetMapping("/{id}")
    public EmailDto getEmailById(@PathVariable int id){
        return emailService.getEmailById(id);
    }

    @PutMapping("/{id}")
    public EmailDto updateEmail(@PathVariable int id, @RequestBody EmailDto emailRequest){
        return emailService.updateEmail(id, emailRequest);
    }

    @DeleteMapping("/{id}")
    public String deleteEmail(@PathVariable int id){
        return emailService.deleteEmail(id);
    }
}

