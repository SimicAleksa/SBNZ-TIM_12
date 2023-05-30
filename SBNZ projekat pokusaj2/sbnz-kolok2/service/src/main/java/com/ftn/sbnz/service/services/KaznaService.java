package com.ftn.sbnz.service.services;

import com.ftn.sbnz.model.Kazna;
import com.ftn.sbnz.model.Korisnik;
import com.ftn.sbnz.model.Vozac;
import com.ftn.sbnz.service.repositories.KaznaRepository;
import com.ftn.sbnz.service.repositories.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class KaznaService {
    @Autowired
    private KaznaRepository kaznaRepository;
    @Autowired
    private KorisnikRepository korisnikRepository;

    public String platiKaznu(String id) {
        Kazna k = this.kaznaRepository.findById(id).get();
        for (Korisnik kor: korisnikRepository.findAll())
        {
            if (kor instanceof Vozac && ((Vozac) kor).getBrojVozackeDozvole().equals(k.getBrojVozackeDozvole()))
            {
                double trenutnoStanje =((Vozac) kor).getRacun();
                if (trenutnoStanje < k.getNovcanaKazna()) return "nema para";
                double newState = ((Vozac) kor).getRacun() - k.getNovcanaKazna();
                ((Vozac) kor).setRacun(newState);
                korisnikRepository.save(kor);
                k.setVremePlacanja(LocalDateTime.now());
                kaznaRepository.save(k);
                return "OK";
            }
        }
        return "";
    }

    public void resetPlacanje() {
        for (Kazna k : kaznaRepository.findAll())
        {
            k.setVremePlacanja(null);
            kaznaRepository.save(k);
        }
        return;
    }
}
