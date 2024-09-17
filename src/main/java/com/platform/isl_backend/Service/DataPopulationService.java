package com.platform.isl_backend.Service;

import com.platform.isl_backend.Entity.AlphabetSign;
import com.platform.isl_backend.Entity.NumberSign;
import com.platform.isl_backend.Repository.AlphabetSignRepository;
import com.platform.isl_backend.Repository.NumberSignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Objects;

@Service
public class DataPopulationService {

    @Autowired
    private AlphabetSignRepository alphabetSignRepository;

    @Autowired
    private NumberSignRepository numberSignRepository;

    private static final String ALPHABET_DIR = "src/main/resources/static/images/alphabets/";
    private static final String NUMBER_DIR = "src/main/resources/static/images/numbers/";

    // Method to scan and insert alphabet signs
    public void populateAlphabetSigns() {
        File alphabetFolder = new File(ALPHABET_DIR);
        File[] alphabetFiles = alphabetFolder.listFiles();

        if (alphabetFiles != null) {
            for (File file : alphabetFiles) {
                if (file.isFile()) {
                    String fileName = file.getName();
                    String signValue = fileName.substring(0, 1).toUpperCase(); // e.g., 'A' from 'A.png'
                    String imagePath = "/images/alphabets/" + fileName;

                    // Check if it already exists, if not, save it
                    if (alphabetSignRepository.findBySignValue(signValue).isEmpty()) {
                        AlphabetSign alphabetSign = new AlphabetSign(null, signValue, imagePath);
                        alphabetSignRepository.save(alphabetSign);
                    }
                }
            }
        }
    }

    // Method to scan and insert number signs
    public void populateNumberSigns() {
        File numberFolder = new File(NUMBER_DIR);
        File[] numberFiles = numberFolder.listFiles();

        if (numberFiles != null) {
            for (File file : numberFiles) {
                if (file.isFile()) {
                    String fileName = file.getName();
                    Integer signValue = Integer.parseInt(fileName.substring(0, fileName.indexOf("."))); // e.g., '1' from '1.png'
                    String imagePath = "/images/numbers/" + fileName;

                    // Check if it already exists, if not, save it
                    if (numberSignRepository.findBySignValue(signValue).isEmpty()) {
                        NumberSign numberSign = new NumberSign(null, signValue, imagePath);
                        numberSignRepository.save(numberSign);
                    }
                }
            }
        }
    }
}
