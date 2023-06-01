package com.ftn.sbnz.model;


import ch.qos.logback.classic.pattern.LineOfCallerConverter;
import lombok.*;
import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Role(Role.Type.EVENT)
@Timestamp("datum")
public class ZahtevZaKaznu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String sifraKazne;
    private String registarskiBrojVozila;
    private double prekoracenje;
    private String tipLokacije;
    private String tipZahtevaZaKaznu;
    private Date datum = new Date();

    public ZahtevZaKaznu(String sifraKazne, String registarskiBrojVozila, double prekoracenje, String tipLokacije, String tipZahtevaZaKaznu) {
        this.sifraKazne = sifraKazne;
        this.registarskiBrojVozila = registarskiBrojVozila;
        this.prekoracenje = prekoracenje;
        this.tipLokacije = tipLokacije;
        this.tipZahtevaZaKaznu = tipZahtevaZaKaznu;
        this.datum = new Date();
    }
}
