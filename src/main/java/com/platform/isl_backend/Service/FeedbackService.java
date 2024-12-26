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
        if (feedback.getSuggestions() == null) {
            feedback.setSuggestions("No suggestions provided.");
        }
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
        return "Form Type: " + feedback.getFormType() + "\n" +
                "User Type: " + feedback.getUserType() + "\n" +
                "Learning Experience: " + feedback.getQuestion1() + "\n" +
                "Platform Usefulness: " + feedback.getQuestion2() + "\n" +
                "Platform Interactivity: " + feedback.getQuestion3() + "\n" +
                "Learning Outcome: " + feedback.getQuestion4() + "\n" +
                "Recommendation: " + feedback.getQuestion5() + "\n" +
                "Suggestions: " + feedback.getSuggestions() + "\n" +
                "Submitted At: " + feedback.getSubmittedAt();
    }
}
