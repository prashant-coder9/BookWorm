
package com.bookworm.services;

import java.io.File;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import com.bookworm.entities.EmailDetails;
 

@Service
public class EmailServiceImpl implements EmailService {
 
    @Autowired private JavaMailSender javaMailSender;
 
    @org.springframework.beans.factory.annotation.Autowired(required=true)
    @Value("${spring.mail.username}") 
    private String sender;
 
    public String sendSimpleMail(EmailDetails details)
    
    {  
        try {
 
            SimpleMailMessage mailMessage= new SimpleMailMessage();
 
            mailMessage.setFrom(sender);
            mailMessage.setTo(details.getRecipient());
            mailMessage.setText("Dear Client, "+"\n"
            		+ "We hope this message finds you well We wanted to inform you that your complaint has been successfully registered in our system. We appreciate you taking the time to bring this matter to our attention.\r\n"
            		+ ". "+"\n"+"Our team is committed to addressing your concerns promptly and providing you with the assistance you require. Rest assured, we are diligently working to investigate and resolve the issue as soon as possible.\r\n"
            				+ "");
            mailMessage.setSubject("Confirmation of Complaint Registration : "+details.getName()+" : "+details.getUseremail());
 
          
            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }
 
        catch (Exception e) {
            return "Error while Sending Mail";
        }
    }
}
    
   /* public String
    sendMailWithAttachment(EmailDetails details)
    {
       
        MimeMessage mimeMessage
            = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;
 
        try {
 
            
            mimeMessageHelper  = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(details.getRecipient());
            mimeMessageHelper.setText(details.getMsgBody());
            mimeMessageHelper.setSubject(
               // details.getName()+details.getUseremail());
 
            // Adding the attachment
            //FileSystemResource file= new FileSystemResource(new File(details.getAttachment()));
 
            mimeMessageHelper.addAttachment(
                file.getFilename(), file);
 

            javaMailSender.send(mimeMessage);
            return "Mail sent Successfully";
        }
 
        catch (MessagingException e) 
        {
 
            return "Error while sending mail!!!";
        }
    }
}*/