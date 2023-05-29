package com.ftn.sbnz.service.services;

import com.ftn.sbnz.service.repositories.VoziloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoziloService {
    @Autowired
    private VoziloRepository voziloRepository;
}
