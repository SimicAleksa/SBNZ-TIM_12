package com.ftn.sbnz.service.controllers;

import com.ftn.sbnz.model.PodaciSaRadaraDTO;
import com.ftn.sbnz.service.services.KaznaService;
import com.ftn.sbnz.service.services.PodaciSaRadaraService;
import com.ftn.sbnz.service.services.PravilaService;
import org.kie.api.runtime.KieSession;
import org.kie.api.time.SessionClock;
import org.kie.api.time.SessionPseudoClock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

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
        kieSession.insert(new PodaciSaRadaraDTO(dto));
        kieSession.fireAllRules();
        pravilaService.saveObjectsInRepos(kieSession);
        pravilaService.saveKieSession(kieSession);
    }

    @PostMapping(value = "/advanceTime")
    public void advanceTime() {
        KieSession kieSession = pravilaService.readKieSession();

        SessionPseudoClock clock = kieSession.getSessionClock();
        System.out.println("Vrijeme prije pomijeranja je bilo " + ((SessionClock) kieSession.getSessionClock()).getCurrentTime());
        //clock.advanceTime(200, TimeUnit.DAYS);
        System.out.println("Vrijeme nakon pomijeranja je " + ((SessionClock) kieSession.getSessionClock()).getCurrentTime());
        pravilaService.vratiVrijemeObjektimaUBazi();
        kieSession = pravilaService.vratiVrijemeObjektimaUSesiji(kieSession);


        kieSession.fireAllRules();
        pravilaService.saveObjectsInRepos(kieSession);
        pravilaService.saveKieSession(kieSession);
    }


}




