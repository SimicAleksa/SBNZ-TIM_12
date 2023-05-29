package com.ftn.sbnz.service.services;

import com.ftn.sbnz.model.Korisnik;
import com.ftn.sbnz.model.dtos.LoginDTO;
import com.ftn.sbnz.service.repositories.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KorisnikService {
    @Autowired
    private KorisnikRepository korisnikRepository;

    public Korisnik tryToLogIn(LoginDTO dto) {
        Korisnik k = korisnikRepository.findByEmailAndSifra(dto.getEmail(), dto.getSifra());
        return k;
    }
}
