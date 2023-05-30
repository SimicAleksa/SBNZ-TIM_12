package com.ftn.sbnz.service.repositories;

import com.ftn.sbnz.model.Korisnik;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface KorisnikRepository extends MongoRepository<Korisnik, String> {
    Korisnik findByEmailAndSifra(String email, String sifra);

    Korisnik findByEmail(String email);
}
