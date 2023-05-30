package com.ftn.sbnz.service.services;

import com.ftn.sbnz.model.Kazna;
import com.ftn.sbnz.model.Korisnik;
import com.ftn.sbnz.model.Vozac;
import com.ftn.sbnz.model.Vozilo;
import com.ftn.sbnz.model.dtos.AddDriverDTO;
import com.ftn.sbnz.model.dtos.CarDTO;
import com.ftn.sbnz.model.dtos.DriverDTO;
import com.ftn.sbnz.model.dtos.LoginDTO;
import com.ftn.sbnz.service.repositories.KaznaRepository;
import com.ftn.sbnz.service.repositories.KorisnikRepository;
import com.ftn.sbnz.service.repositories.VoziloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class KorisnikService {
    @Autowired
    private KorisnikRepository korisnikRepository;
    @Autowired
    VoziloRepository voziloRepository;
    @Autowired
    KaznaRepository kaznaRepository;

    public Korisnik tryToLogIn(LoginDTO dto) {
        Korisnik k = korisnikRepository.findByEmailAndSifra(dto.getEmail(), dto.getSifra());
        return k;
    }

    public void addDriver(AddDriverDTO dto) {
        for (CarDTO c: dto.getCars())
        {
            voziloRepository.save(new Vozilo(c.getRegistrationNumber(), dto.getBrVozacke(), c.getCarColor(), c.getCarBrand(), c.getCarModel()));
        }
        Vozac v = new Vozac(dto.getBrVozacke(), dto.getIme(), dto.getPrezime(), dto.getEmail(), dto.getSifra(), 0);
        korisnikRepository.save(v);
    }

    public DriverDTO getUserData(LoginDTO dto) {
        Vozac v = (Vozac) korisnikRepository.findByEmail(dto.getEmail());
        ArrayList<Kazna> korisnikoveKazne = kaznaRepository.findByBrojVozackeDozvole(v.getBrojVozackeDozvole());
        return new DriverDTO(v, korisnikoveKazne);

    }
}
