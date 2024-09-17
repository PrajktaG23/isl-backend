package com.platform.isl_backend.Repository;

import com.platform.isl_backend.Entity.NumberSign;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface NumberSignRepository extends JpaRepository<NumberSign, Long> {
    Optional<NumberSign> findBySignValue(Integer signValue);  // Find number by its value (e.g., '1')
}

