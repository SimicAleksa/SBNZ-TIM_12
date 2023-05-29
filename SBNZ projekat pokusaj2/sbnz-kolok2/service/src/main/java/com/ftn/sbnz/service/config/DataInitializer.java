package com.ftn.sbnz.service.config;

import com.ftn.sbnz.model.Admin;
import com.ftn.sbnz.model.PodaciSaRadaraDTO;
import com.ftn.sbnz.model.Role;
import com.ftn.sbnz.model.Vozac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
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
//        PodaciSaRadaraDTO p1 = new PodaciSaRadaraDTO("id1", "AV 065", "Sabac", 52.00, "kisa", "naseljeno mesto");
//        mongoTemplate.insert(p1);

//        Vozac v1 = new Vozac("broj vozacke 123", "Marko", "Markovic", "marko@gmail.com", "m", 0);
//        Vozac v2 = new Vozac("broj vozacke 321", "Pera", "Peric", "pera@gmail.com", "p", 2);
//        Admin a1 = new Admin("Admin", "Admin", "admin@gmail.com", "a");
//        mongoTemplate.insert(v1, "korisnik");
//        mongoTemplate.insert(v2, "korisnik");
//        mongoTemplate.insert(a1, "korisnik");


    }
}
