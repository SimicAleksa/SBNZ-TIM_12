package com.ftn.sbnz.service.repositories;

import com.ftn.sbnz.model.Kazna;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface KaznaRepository extends MongoRepository<Kazna, String> {
}
