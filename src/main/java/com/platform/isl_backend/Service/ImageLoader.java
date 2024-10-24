//package com.platform.isl_backend.Service;
//
//import com.platform.isl_backend.Entity.AlphabetSign;
//import com.platform.isl_backend.Entity.NumberSign;
//import com.platform.isl_backend.Repository.AlphabetSignRepository;
//import com.platform.isl_backend.Repository.NumberSignRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
//@Service
//public class ImageLoader implements CommandLineRunner {
//
//    @Autowired
//    private AlphabetSignRepository alphabetSignRepository;
//
//    @Autowired
//    private NumberSignRepository numberSignRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
//        // Load alphabet images
//        loadAlphabetSigns();
//
//        // Load number images
//        loadNumberSigns();
//    }
//
//    private void loadAlphabetSigns() throws IOException {
//        ClassPathResource alphabetDir = new ClassPathResource("static/images/alphabets/");
//        Path alphabetPath = Paths.get(alphabetDir.getURI());
//
//        Files.list(alphabetPath).forEach(path -> {
//            String filename = path.getFileName().toString();
//            String signValue = filename.substring(0, filename.indexOf('.')); // Get the letter
//
//            // Save to database
//            AlphabetSign alphabetSign = new AlphabetSign();
//            alphabetSign.setSignValue(signValue.toUpperCase()); // Example: 'A'
//            alphabetSign.setImagePath("/images/alphabets/" + filename); // Example: "/images/alphabets/A.png"
//            alphabetSignRepository.save(alphabetSign);
//        });
//    }
//
//    private void loadNumberSigns() throws IOException {
//        ClassPathResource numberDir = new ClassPathResource("static/images/numbers/");
//        Path numberPath = Paths.get(numberDir.getURI());
//
//        Files.list(numberPath).forEach(path -> {
//            String filename = path.getFileName().toString();
//            String signValue = filename.substring(0, filename.indexOf('.')); // Get the number
//
//            // Save to database
//            NumberSign numberSign = new NumberSign();
//            numberSign.setSignValue(Integer.parseInt(signValue)); // Example: 1
//            numberSign.setImagePath("/images/numbers/" + filename); // Example: "/images/numbers/1.png"
//            numberSignRepository.save(numberSign);
//        });
//    }
//}