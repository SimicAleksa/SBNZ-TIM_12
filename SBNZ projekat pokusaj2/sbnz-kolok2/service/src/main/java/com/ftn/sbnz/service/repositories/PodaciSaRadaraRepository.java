package com.ftn.sbnz.service.repositories;

import com.ftn.sbnz.model.PodaciSaRadaraDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PodaciSaRadaraRepository extends MongoRepository<PodaciSaRadaraDTO, String> {
}
