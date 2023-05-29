package com.ftn.sbnz.service.services;

import com.ftn.sbnz.service.repositories.OduzimanjeVozackeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OduzimanjeVozackeService {
    @Autowired
    private OduzimanjeVozackeRepository oduzimanjeVozackeRepository;
}
