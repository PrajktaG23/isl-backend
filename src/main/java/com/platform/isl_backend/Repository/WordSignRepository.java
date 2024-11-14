package com.platform.isl_backend.Repository;

import com.platform.isl_backend.Entity.WordSign;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WordSignRepository extends JpaRepository<WordSign , Long> {

    Optional<WordSign> findBySignValue(String signValue);
}
