package com.platform.isl_backend.Controller;
import com.platform.isl_backend.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/email")
public class EmailController {
    @Autowired
    private EmailService emailService;


    @PostMapping("/send")
    public String sendEmail(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String subject,
            @RequestParam String message
    ) {
        String to = "indianSignLanguage00@gmail.com";  // Replace with your Gmail address
        String body = "Name: " + name + "\nEmail: " + email + "\nSubject: " + subject + "\n\nMessage: " + message;

        try {
            emailService.sendEmail(to, subject, body);
            return "Message sent successfully!";
        } catch (Exception e) {
            return "Failed to send message.";
        }
    }
}
