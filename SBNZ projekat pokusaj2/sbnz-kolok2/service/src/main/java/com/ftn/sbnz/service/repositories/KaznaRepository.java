package com.ftn.sbnz.service.repositories;

import com.ftn.sbnz.model.Kazna;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;

public interface KaznaRepository extends MongoRepository<Kazna, String> {
    ArrayList<Kazna> findByBrojVozackeDozvole(String brojVozackeDozvole);
}
