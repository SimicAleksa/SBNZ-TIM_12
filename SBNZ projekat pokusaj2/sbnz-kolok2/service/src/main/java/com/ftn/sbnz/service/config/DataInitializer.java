package com.ftn.sbnz.service.config;

import com.ftn.sbnz.model.*;
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

//        PodaciSaRadaraDTO p1 = new PodaciSaRadaraDTO("1", "3905732507920", "Veternik",
//                54.2, "kisa", "naseljeno mesto");
//
//        Vozac vozac1 = new Vozac("brojVozacke123", "Marko", "Markovic", "marko@gmail.com", "m", 2);
//        Vozilo vozilo1 = new Vozilo("065-AV-243", "brojVozacke123",
//                "crvena", "Mercedes", "B180");
//        mongoTemplate.insert(p1);
//        mongoTemplate.insert(vozac1);
//        mongoTemplate.insert(vozilo1);

//        PodaciSaRadaraDTO p2 = new PodaciSaRadaraDTO("2", "49489489", "Veternik",
//                54.2, "kisa", "naseljeno mesto");
//        PodaciSaRadaraDTO p3 = new PodaciSaRadaraDTO("3", "45145", "Adice",
//                64.2, "sneg", "nenaseljeno mesto");
//        PodaciSaRadaraDTO p4 = new PodaciSaRadaraDTO("4", "51461", "Novo nasalje",
//                34.2, "regularno", "nenaseljeno mesto");
//        mongoTemplate.insert(p2);
//        mongoTemplate.insert(p3);
//        mongoTemplate.insert(p4);
//        Kazna k1 = new Kazna("065-AV-243", "brojVozacke123", 10000, 5, 0, true, true);
//        Kazna k2 = new Kazna("345-35-365", "123", 4000, 0, 0, true, false);
//        Kazna k3 = new Kazna("765-5678-6", "bro", 3000, 15, 60, false, true);
//        mongoTemplate.insert(k1);
//        mongoTemplate.insert(k2);
//        mongoTemplate.insert(k3);

    }
}
