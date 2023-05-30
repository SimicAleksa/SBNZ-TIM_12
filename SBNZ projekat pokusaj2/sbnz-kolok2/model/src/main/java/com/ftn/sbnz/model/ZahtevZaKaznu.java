package com.ftn.sbnz.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.kie.api.definition.type.Role;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Role(Role.Type.EVENT)
public class ZahtevZaKaznu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String sifraKazne;
    private String registarskiBrojVozila;
    private double prekoracenje;
    private String tipLokacije;
    private String tipZahtevaZaKaznu;


}
