package com.platform.isl_backend.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username; // optional: to identify the user providing feedback
    private String userType; // "student" or "guardian"
    private String formType; // "learning" or "assessment"
    private String question1;
    private String question2;
    private String question3;
    private String question4;
    private String question5;
    private String suggestions;
    private LocalDateTime submittedAt;
}
