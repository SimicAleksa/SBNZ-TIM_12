package com.ftn.sbnz.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Patrola implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String registarskiBrojVozila;
    private String bojaVozila;
    private String markaVozila;
    private String modelVozila;
    private LocalDateTime datum;

    public Patrola(String registarskiBrojVozila, String bojaVozila, String markaVozila, String modelVozila) {
        this.registarskiBrojVozila = registarskiBrojVozila;
        this.bojaVozila = bojaVozila;
        this.markaVozila = markaVozila;
        this.modelVozila = modelVozila;
        this.datum = LocalDateTime.now();
    }
}
