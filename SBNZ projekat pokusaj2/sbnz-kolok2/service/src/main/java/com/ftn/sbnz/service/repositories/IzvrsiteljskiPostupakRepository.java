package com.ftn.sbnz.service.repositories;

import com.ftn.sbnz.model.IzvrsiteljskiPostupak;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IzvrsiteljskiPostupakRepository extends MongoRepository<IzvrsiteljskiPostupak, String> {
}
