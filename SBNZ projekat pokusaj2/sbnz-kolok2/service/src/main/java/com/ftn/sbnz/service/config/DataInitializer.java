package com.ftn.sbnz.service.config;

import com.ftn.sbnz.model.PodaciSaRadaraDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void run(String... args) throws Exception {
        
//        Vozilo v1 = new Vozilo("crvena", "Mercedes", "B180", "065-AV-435");
//        mongoTemplate.insert(v1, "vozilo");
        PodaciSaRadaraDTO p1 = new PodaciSaRadaraDTO("id1", "AV 065", "Sabac", 52.00, "kisa", "naseljeno mesto");
        mongoTemplate.insert(p1);

    }
}
