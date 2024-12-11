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
}
