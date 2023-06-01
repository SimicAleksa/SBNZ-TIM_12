package com.ftn.sbnz.service.repositories;

import com.ftn.sbnz.model.Patrola;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatrolaRepository extends MongoRepository<Patrola, String> {
}
