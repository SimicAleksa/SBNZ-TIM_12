package com.ftn.sbnz.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.time.LocalDateTime;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PodaciSaRadaraDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String registarskiBrojVozila;
    private String nazivLokacije;
    private String tipLokacije;
    private double zabelezenaBrzina;
    private String vremenskoStanje;

    private double ogranicenje; // ovo je inicijalno setovano na 0 dok se ne sracuna u template-u

    private boolean izracunataBrzina;
    private LocalDateTime datum;

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
        this.datum = LocalDateTime.now();
    }
    public PodaciSaRadaraDTO (PodaciSaRadaraDTO dto)
    {
        this.id = dto.getId();
        this.registarskiBrojVozila = dto.getRegistarskiBrojVozila();
        this.nazivLokacije = dto.getNazivLokacije();
        this.tipLokacije = dto.getTipLokacije();
        this.zabelezenaBrzina = dto.getZabelezenaBrzina();
        this.vremenskoStanje = dto.getVremenskoStanje();
        this.ogranicenje = 0;
        this.izracunataBrzina = false;
        this.datum = LocalDateTime.now();

    }

}
