package com.platform.isl_backend.Controller;

import com.platform.isl_backend.Entity.AlphabetSign;
import com.platform.isl_backend.Entity.NumberSign;
import com.platform.isl_backend.Entity.WordSign;
import com.platform.isl_backend.Service.NumberSignService;
import com.platform.isl_backend.Service.AlphabetSignService;
import com.platform.isl_backend.Service.WordSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/signs")
public class SignController {
    @Autowired
    private AlphabetSignService alphabetSignService;

    @Autowired
    private NumberSignService numberSignService;

    @Autowired
    private WordSignService wordSignService;


    // Get a specific alphabet sign by value (e.g., 'A')
    @GetMapping("/alphabet/{value}")
    public ResponseEntity<AlphabetSign> getAlphabetSignByValue(@PathVariable String value) {
        Optional<AlphabetSign> sign = alphabetSignService.getAlphabetSignByValue(value);
        return sign.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get a specific number sign by value (e.g., 1)
    @GetMapping("/number/{value}")
    public ResponseEntity<NumberSign> getNumberSignByValue(@PathVariable Integer value) {
        Optional<NumberSign> sign = numberSignService.getNumberSignByValue(value);
        return sign.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get word sign (video and image) by value
    @GetMapping("/words/{value}")
    public ResponseEntity<WordSign> getWordSignByValue(@PathVariable String value) {
        Optional<WordSign> sign = wordSignService.getWordSignByValue(value);
        return sign.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    //to fetch words starting with a specific alphabet and sort them alphabetically
    @GetMapping("/words/alphabet/{alphabet}")
    public ResponseEntity<List<WordSign>> getWordsByAlphabet(@PathVariable String alphabet) {
        List<WordSign> words = wordSignService.getWordsStartingWith(alphabet);
        if (words.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(words);
    }

}
