package com.platform.isl_backend.Controller;
import com.platform.isl_backend.DTO.FeedbackDTO;
import com.platform.isl_backend.Entity.Feedback;
import com.platform.isl_backend.Service.EmailService;
import com.platform.isl_backend.Service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/email")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @Autowired
    private FeedbackService feedbackService;

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


    @PostMapping("/feedback/submit")
    public String submitFeedback(@RequestBody FeedbackDTO feedbackDTO) {

        // Convert DTO to Entity
        Feedback feedback = mapDtoToEntity(feedbackDTO);

        feedbackService.saveFeedback(feedback);
        return "Feedback submitted successfully!";
    }
    private Feedback mapDtoToEntity(FeedbackDTO dto) {
        Feedback feedback = new Feedback();
        feedback.setUsername(dto.getUsername());
        feedback.setUserType(dto.getUserType());
        feedback.setFormType(dto.getFormType());
        feedback.setQuestion1(dto.getLearningExperience());
        feedback.setQuestion2(dto.getPlatformUsefulness());
        feedback.setQuestion3(dto.getPlatformInteractivity());
        feedback.setQuestion4(dto.getLearningOutcome());
        feedback.setQuestion5(dto.getRecommendation());
        feedback.setSuggestions(dto.getSuggestions());
        return feedback;
    }
}
