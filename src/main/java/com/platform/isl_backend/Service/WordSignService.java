package com.platform.isl_backend.Service;

import com.platform.isl_backend.Entity.WordSign;
import com.platform.isl_backend.Repository.WordSignRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class WordSignService {
    @Autowired
    private WordSignRepository wordSignRepository;

    public Optional<WordSign> getWordSignByValue(String signValue) {
        return wordSignRepository.findBySignValue(signValue);
    }

    public WordSign saveWordSign(WordSign wordSign) {
        return wordSignRepository.save(wordSign);
    }

    public List<WordSign> getWordsStartingWith(String alphabet) {
        return wordSignRepository.findBySignValueStartingWithOrderBySignValue(alphabet.toUpperCase());
    }

}
