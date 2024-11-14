package com.platform.isl_backend.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "words_signs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WordSign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sign_value", nullable = false)
    private String signValue;  // words

    @Column(name = "video_path", nullable = false)
    private String videoPath;  // Path to video
}
