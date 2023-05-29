package com.ftn.sbnz.service.controllers;

import com.ftn.sbnz.model.dtos.LoginDTO;
import com.ftn.sbnz.service.services.PodaciSaRadaraService;
import com.ftn.sbnz.service.services.PravilaService;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PodaciSaRadaraController {
    @Autowired
    PodaciSaRadaraService podaciSaRadaraService;
    @Autowired
    PravilaService pravilaService;

    @PostMapping(value = "/script", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertDataToKSession(@RequestBody LoginDTO dto) {

    }

    @PostMapping(value = "/init")
    public void prepare() {
        pravilaService.prepareSystem();
    }


}




