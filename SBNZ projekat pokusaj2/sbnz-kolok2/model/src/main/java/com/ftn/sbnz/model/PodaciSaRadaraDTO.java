package com.ftn.sbnz.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PodaciSaRadaraDTO {

    private String id;
    private String registarskiBrojVozila;
    private String nazivLokacije;
    private String tipLokacije;
    private double zabelezenaBrzina;
    private String vremenskoStanje;

    private double ogranicenje; // ovo je inicijalno setovano na 0 dok se ne sracuna u template-u

    private boolean izracunataBrzina;


//    public PodaciSaRadaraDTO() {
//        this.ogranicenje = 0;
//    }


    public PodaciSaRadaraDTO(String id, String registarskiBrojVozila, String nazivLokacije, double zabelezenaBrzina,
                             String vremenskoStanje, String tipLokacije) {
        this.id = id;
        this.registarskiBrojVozila = registarskiBrojVozila;
        this.nazivLokacije = nazivLokacije;
        this.tipLokacije = tipLokacije;
        this.zabelezenaBrzina = zabelezenaBrzina;
        this.vremenskoStanje = vremenskoStanje;
        this.ogranicenje = 0;
        this.izracunataBrzina = false;
    }

//    public String getRegistarskiBrojVozila() {
//        return registarskiBrojVozila;
//    }
//
//    public void setRegistarskiBrojVozila(String registarskiBrojVozila) {
//        this.registarskiBrojVozila = registarskiBrojVozila;
//    }
//
//    public String getNazivLokacije() {
//        return nazivLokacije;
//    }
//
//    public void setNazivLokacije(String nazivLokacije) {
//        this.nazivLokacije = nazivLokacije;
//    }
//
//    public double getZabelezenaBrzina() {
//        return zabelezenaBrzina;
//    }
//
//    public void setZabelezenaBrzina(double zabelezenaBrzina) {
//        this.zabelezenaBrzina = zabelezenaBrzina;
//    }
//
//    public String getVremenskoStanje() {
//        return vremenskoStanje;
//    }
//
//    public void setVremenskoStanje(String vremenskoStanje) {
//        this.vremenskoStanje = vremenskoStanje;
//    }
//
//    public String getTipLokacije() {
//        return tipLokacije;
//    }
//
//    public void setTipLokacije(String tipLokacije) {
//        this.tipLokacije = tipLokacije;
//    }
//
//    public double getOgranicenje() {
//        return ogranicenje;
//    }
//
//    public void setOgranicenje(double ogranicenje) {
//        this.ogranicenje = ogranicenje;
//    }
//
//
}
