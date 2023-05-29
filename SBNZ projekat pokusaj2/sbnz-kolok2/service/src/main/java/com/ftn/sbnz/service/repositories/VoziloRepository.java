package com.ftn.sbnz.service.repositories;

import com.ftn.sbnz.model.Vozilo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VoziloRepository extends MongoRepository<Vozilo, String> {
}
