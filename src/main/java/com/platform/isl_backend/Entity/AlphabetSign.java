package com.platform.isl_backend.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "alphabet_signs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlphabetSign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sign_value", nullable = false)
    private String signValue;  // Single alphabet (A-Z)

    @Column(name = "image_path", nullable = false)
    private String imagePath;  // Path to image
}
