package com.ftn.sbnz.service.services;

import com.ftn.sbnz.model.Kazna;
import com.ftn.sbnz.model.PodaciSaRadaraDTO;
import com.ftn.sbnz.service.repositories.PodaciSaRadaraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PodaciSaRadaraService {
    @Autowired
    private PodaciSaRadaraRepository podaciSaRadaraRepository;

    public List<PodaciSaRadaraDTO> getAll() {
        return this.podaciSaRadaraRepository.findAll();
    }

    public List<PodaciSaRadaraDTO> getNonZero() {
        ArrayList<PodaciSaRadaraDTO> retVal = new ArrayList<>();
        for (PodaciSaRadaraDTO p: podaciSaRadaraRepository.findAll())
        {
            if(p.getOgranicenje()!=0) retVal.add(p);
        }
        return retVal;
    }


}
