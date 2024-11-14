package com.platform.isl_backend.Service;
import com.platform.isl_backend.Entity.WordSign;
import com.platform.isl_backend.Repository.WordSignRepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Optional;

public class WordSignService {
    @Autowired
    private WordSignRepository wordSignRepository;

    // Get alphabet sign by value (e.g., 'A', 'B', etc.)
    public Optional<WordSign> getWordSignByValue(String signValue) {
        return wordSignRepository.findBySignValue(signValue.toLowerCase());
    }
}
