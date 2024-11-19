//package com.platform.isl_backend.Service;
//
//import com.platform.isl_backend.Entity.WordSign;
//import com.platform.isl_backend.Repository.WordSignRepository;
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
//public class VideoLoader implements CommandLineRunner {
//
//    @Autowired
//    private WordSignRepository wordSignRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
//        // Load word videos
//        loadWordVideos();
//    }
//
//    private void loadWordVideos() throws IOException {
//        // Videos are stored in the "static/videos/words/" directory
//        ClassPathResource videoDir = new ClassPathResource("static/videos/words/");
//        Path videoPath = Paths.get(videoDir.getURI());
//
//        // Iterate over all files in the directory
//        Files.list(videoPath).forEach(path -> {
//            String filename = path.getFileName().toString();
//
//            // Check if the file is a .MOV video
//            if (filename.endsWith(".MOV")) {
//                String signValue = filename.substring(0, filename.indexOf('.')); // Extract the word from filename
//
//                // Create a new WordSign entity
//                WordSign wordSign = new WordSign();
//                wordSign.setSignValue(signValue);
//                wordSign.setVideoPath("/videos/words/" + filename); // Path to access the video
//                // Save to the database
//                wordSignRepository.save(wordSign);
//            }
//        });
//    }
//}
