package com.platform.isl_backend.Service;

import com.platform.isl_backend.Entity.Feedback;
import com.platform.isl_backend.Repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private JavaMailSender mailSender;

    public void saveFeedback(Feedback feedback) {
        // Set the submission timestamp
        feedback.setSubmittedAt(LocalDateTime.now());
        // Save to the database
        feedbackRepository.save(feedback);
        // Send the feedback as an email
        sendFeedbackEmail(feedback);
    }

    private void sendFeedbackEmail(Feedback feedback) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("indianSignLanguage00@gmail.com"); // Replace with recipient email
        message.setSubject("New Feedback Submitted");
        message.setText(buildEmailBody(feedback));
        mailSender.send(message);
    }

    private String buildEmailBody(Feedback feedback) {
        return "User Type: " + feedback.getUserType() + "\n" +
                "Question 1: " + feedback.getQuestion1() + "\n" +
                "Question 2: " + feedback.getQuestion2() + "\n" +
                "Question 3: " + feedback.getQuestion3() + "\n" +
                "Question 4: " + feedback.getQuestion4() + "\n" +
                "Question 5: " + feedback.getQuestion5() + "\n" +
                "Suggestions: " + feedback.getSuggestions() + "\n" +
                "Submitted At: " + feedback.getSubmittedAt();
    }
}
