package com.ftn.sbnz.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vozilo {
    private String id;
    private String brojVozackeDozvoleVozaca;
    private String boja;
    private String marka;
    private String model;
    private String registarskiBrojVozila;
//    private List<Kazna> kazne;


}
