package com.ftn.sbnz.service.controllers;

import com.ftn.sbnz.service.services.PodaciSaRadaraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PodaciSaRadaraController {
    @Autowired
    PodaciSaRadaraService podaciSaRadaraService;
}
