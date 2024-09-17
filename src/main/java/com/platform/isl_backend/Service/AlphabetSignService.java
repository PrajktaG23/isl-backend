package com.platform.isl_backend.Service;

import com.platform.isl_backend.Entity.AlphabetSign;
import com.platform.isl_backend.Repository.AlphabetSignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlphabetSignService {
    @Autowired
    private AlphabetSignRepository alphabetSignRepository;

    // Get alphabet sign by value (e.g., 'A', 'B', etc.)
    public Optional<AlphabetSign> getAlphabetSignByValue(String signValue) {
        return alphabetSignRepository.findBySignValue(signValue.toUpperCase());
    }
}
