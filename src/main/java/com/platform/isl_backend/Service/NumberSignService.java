package com.platform.isl_backend.Service;

import com.platform.isl_backend.Entity.NumberSign;
import com.platform.isl_backend.Repository.NumberSignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NumberSignService {

    @Autowired
    private NumberSignRepository numberSignRepository;

    // Get number sign by value (e.g., 1, 2, etc.)
    public Optional<NumberSign> getNumberSignByValue(Integer signValue) {
        return numberSignRepository.findBySignValue(signValue);
    }
}
