package com.bookworm.controllers;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookworm.entities.EmailDetails;
import com.bookworm.services.EmailService;
 

@RestController
@CrossOrigin("*")
public class EmailController {
 
    @Autowired private EmailService emailService;
 
    
    @PostMapping("/sendMail")
    public ResponseEntity <String> sendMail(@RequestBody EmailDetails details)
    {  	System.out.println(details);    
        String status= emailService.sendSimpleMail(details);
        return ResponseEntity.ok (status);
    }
 
 /*
    @PostMapping("/sendMailWithAttachment")
    public void sendMailWithAttachment( @RequestParam("message") String message)
    {
         emailService.sendMailWithAttachment(message);
 
        
    }*/
}