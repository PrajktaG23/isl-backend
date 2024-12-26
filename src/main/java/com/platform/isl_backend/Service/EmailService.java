package com.platform.isl_backend.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;


    public void sendEmail(String to, String subject, String message) throws MailException {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setFrom("indianSignLanguage@gmail.com");
        email.setTo(to);
        email.setSubject(subject);
        email.setText(message);

        mailSender.send(email);
    }

    public void sendWelcomeEmail(String toEmail,String username) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Welcome to the ISLMate Platform!");
        message.setText("Hi " + username + ",\n\nThank you for registering.\nWe're excited to have you with us and start your Indian Sign Language Journey with us!!\n\nBest regards,\nISLMate Team");

        mailSender.send(message);
    }
}
