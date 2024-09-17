package com.platform.isl_backend.initializer;

import com.platform.isl_backend.Service.DataPopulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    @Autowired
    private DataPopulationService dataPopulationService;

    @Override
    public void run(String... args) throws Exception {
        // Populate the alphabet and number signs in the database
        dataPopulationService.populateAlphabetSigns();
        dataPopulationService.populateNumberSigns();
    }
}
