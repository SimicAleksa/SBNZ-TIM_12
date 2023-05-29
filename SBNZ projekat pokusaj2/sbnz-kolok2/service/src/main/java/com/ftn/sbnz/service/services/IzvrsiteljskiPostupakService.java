package com.ftn.sbnz.service.services;

import com.ftn.sbnz.service.repositories.IzvrsiteljskiPostupakRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IzvrsiteljskiPostupakService {
    @Autowired
    private IzvrsiteljskiPostupakRepository izvrsiteljskiPostupakRepository;
}
