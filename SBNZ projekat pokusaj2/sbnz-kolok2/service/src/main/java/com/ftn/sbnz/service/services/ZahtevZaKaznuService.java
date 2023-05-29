package com.ftn.sbnz.service.services;

import com.ftn.sbnz.service.repositories.ZahtevZaKaznuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZahtevZaKaznuService {
    @Autowired
    private ZahtevZaKaznuRepository zahtevZaKaznuRepository;
}
