package com.ftn.sbnz.service.controllers;

import com.ftn.sbnz.model.PodaciSaRadaraDTO;
import com.ftn.sbnz.model.dtos.LoginDTO;
import com.ftn.sbnz.service.services.KaznaService;
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

    @Autowired
    KaznaService kaznaService;

    @PostMapping(value = "/init")
    public void prepare() {
        pravilaService.prepareSystem();
    }

    @PostMapping(value = "/delete")
    public void delete() {
        this.pravilaService.deleteCreated();
    }

    @PostMapping(value = "/radar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void getDataFromRadar(@RequestBody PodaciSaRadaraDTO dto) {
        KieSession kieSession = pravilaService.readKieSession();
        kieSession.insert(dto);
        kieSession.fireAllRules();
        pravilaService.saveObjects(kieSession);

    }


}




