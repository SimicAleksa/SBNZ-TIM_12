package com.ftn.sbnz.service.controllers;

import com.ftn.sbnz.model.Kazna;
import com.ftn.sbnz.model.PodaciSaRadaraDTO;
import com.ftn.sbnz.model.dtos.AddDriverDTO;
import com.ftn.sbnz.service.repositories.KaznaRepository;
import com.ftn.sbnz.service.services.PodaciSaRadaraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class DataController {

    @Autowired
    private PodaciSaRadaraService podaciSaRadaraService;

    @Autowired
    private KaznaRepository kaznaRepository;

    @PostMapping(value = "/getPodaciSRadara")
    public ResponseEntity<List<PodaciSaRadaraDTO>> getPodaciSRadara() {
        List<PodaciSaRadaraDTO> podaci = this.podaciSaRadaraService.getNonZero();
        return new ResponseEntity<>(podaci, HttpStatus.OK);
    }

    @PostMapping(value = "/getKazne")
    public ResponseEntity<List<Kazna>> getKazne() {
        List<Kazna> podaci = this.kaznaRepository.findAll();
        return new ResponseEntity<>(podaci, HttpStatus.OK);
    }
}
