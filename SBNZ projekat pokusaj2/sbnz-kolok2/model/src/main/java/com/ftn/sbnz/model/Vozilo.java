package com.ftn.sbnz.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vozilo {
    @Id
    private String registarskiBrojVozila;
    private String brojVozackeDozvoleVozaca;
    private String boja;
    private String marka;
    private String model;
//    private List<Kazna> kazne;


}
