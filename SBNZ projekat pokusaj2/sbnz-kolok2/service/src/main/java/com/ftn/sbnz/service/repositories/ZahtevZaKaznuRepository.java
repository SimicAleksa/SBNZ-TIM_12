package com.ftn.sbnz.service.repositories;

import com.ftn.sbnz.model.ZahtevZaKaznu;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ZahtevZaKaznuRepository extends MongoRepository<ZahtevZaKaznu, String> {
}
