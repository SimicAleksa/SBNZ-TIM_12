package com.ftn.sbnz.service.controllers;

import com.ftn.sbnz.model.Korisnik;
import com.ftn.sbnz.model.dtos.LoginDTO;
import com.ftn.sbnz.service.services.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class KorisnikController {
    @Autowired
    private KorisnikService korisnikService;

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Korisnik> login(@RequestBody LoginDTO dto) {
        Korisnik k = korisnikService.tryToLogIn(dto);
        if (k!=null)
        {
            return new ResponseEntity<>(k, HttpStatus.OK);
        }
        return new ResponseEntity<>(k, HttpStatus.BAD_REQUEST);

    }

}
