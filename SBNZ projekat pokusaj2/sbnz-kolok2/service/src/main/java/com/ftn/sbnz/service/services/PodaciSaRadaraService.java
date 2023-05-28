package com.ftn.sbnz.service.services;

import com.ftn.sbnz.service.repositories.PodaciSaRadaraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PodaciSaRadaraService {
    @Autowired
    private PodaciSaRadaraRepository podaciSaRadaraRepository;
}
