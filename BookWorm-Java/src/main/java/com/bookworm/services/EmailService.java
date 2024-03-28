

 
package com.bookworm.services;

import org.springframework.stereotype.Component;

import com.bookworm.entities.EmailDetails;

public interface EmailService {
 
  
    // To send a simple email
    String sendSimpleMail(EmailDetails details);
 

    // To send an email with attachment
    //void sendMailWithAttachment(String details);
}