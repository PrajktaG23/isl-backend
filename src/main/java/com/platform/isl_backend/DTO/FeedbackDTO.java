package com.platform.isl_backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackDTO {
    private String username; // optional: to identify the user providing feedback
    private String userType; // "student" or "guardian"
    private String formType; // "learning" or "assessment"
    private String learningExperience; // Maps to question1
    private String platformUsefulness; // Maps to question2
    private String platformInteractivity; // Maps to question3
    private String learningOutcome; // Maps to question4
    private String recommendation; // Maps to question5
    private String suggestions;
}
