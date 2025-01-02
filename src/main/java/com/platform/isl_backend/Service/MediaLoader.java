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
//public class MediaLoader implements CommandLineRunner {
//
//    @Autowired
//    private WordSignRepository wordSignRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
//        // Load word videos and images
//        loadWordMedia();
//    }
//
//    private void loadWordMedia() throws IOException {
//        // Videos are stored in "static/videos/words/"
//        ClassPathResource videoDir = new ClassPathResource("static/videos/words/");
//        Path videoPath = Paths.get(videoDir.getURI());
//
//        // Images are stored in "static/images/words/"
//        ClassPathResource imageDir = new ClassPathResource("static/images/words/");
//        Path imagePath = Paths.get(imageDir.getURI());
//
//        // Iterate over all video files
//        Files.list(videoPath).forEach(video -> {
//            try {
//                String videoFilename = video.getFileName().toString();
//
//                // Normalize video name: remove special characters and convert to lowercase
//                String normalizedVideoName = normalizeFilename(videoFilename.substring(0, videoFilename.indexOf('.')));
//
//                // Find matching image
//                Path matchingImage = Files.list(imagePath)
//                        .filter(image -> {
//                            String imageFilename = image.getFileName().toString();
//                            String normalizedImageName = normalizeFilename(imageFilename.substring(0, imageFilename.indexOf('.')));
//                            return normalizedVideoName.equals(normalizedImageName);
//                        })
//                        .findFirst()
//                        .orElse(null);
//
//                String videoPathValue = "/videos/words/" + videoFilename;
//                String imagePathValue = (matchingImage != null)
//                        ? "/images/words/" + matchingImage.getFileName().toString()
//                        : null;
//
//                // Extract the original word
//                String signValue = videoFilename.substring(0, videoFilename.indexOf('.'));
//
//                // Create or update WordSign entity
//                WordSign wordSign = wordSignRepository.findBySignValue(signValue)
//                        .orElse(new WordSign());
//                wordSign.setSignValue(signValue);
//                wordSign.setVideoPath(videoPathValue);
//                wordSign.setImagePath(imagePathValue);
//
//                // Save to the database
//                wordSignRepository.save(wordSign);
//            } catch (Exception e) {
//                System.err.println("Error processing file: " + video.getFileName());
//                e.printStackTrace();
//            }
//        });
//    }
//
//    private String normalizeFilename(String filename) {
//        return filename.toLowerCase().replaceAll("[^a-z0-9]", ""); // Convert to lowercase and remove non-alphanumeric characters
//    }
//}
