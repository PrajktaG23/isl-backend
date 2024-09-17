package com.platform.isl_backend.Entity;

import jakarta.persistence.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "number_signs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NumberSign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sign_value", nullable = false)
    private Integer signValue;  // Number (0-9, etc.)

    @Column(name = "image_path", nullable = false)
    private String imagePath;  // Path to image
}
