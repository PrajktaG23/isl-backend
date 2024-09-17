package com.platform.isl_backend.Repository;

import com.platform.isl_backend.Entity.AlphabetSign;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AlphabetSignRepository extends JpaRepository<AlphabetSign, Long> {
    Optional<AlphabetSign> findBySignValue(String signValue);  // Find alphabet by its value (e.g., 'A')
}

