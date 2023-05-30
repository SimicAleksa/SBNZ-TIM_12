package com.ftn.sbnz.model;

import lombok.*;
import org.kie.api.definition.type.Role;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Role(Role.Type.EVENT)
public class Kazna implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String registarskiBrojVozila;
    private String brojVozackeDozvole;
    private double novcanaKazna;
    private int brojKaznenihBodova;
    private int duzinaZatvorskeKazne;
    private LocalDateTime datum = LocalDateTime.now();
    private boolean istekla = false;
    private LocalDateTime vremePlacanja;

    public Kazna(String id, String registarskiBrojVozila, String brojVozackeDozvole, double novcanaKazna, int brojKaznenihBodova, int duzinaZatvorskeKazne) {
        this.id = id;
        this.registarskiBrojVozila = registarskiBrojVozila;
        this.brojVozackeDozvole = brojVozackeDozvole;
        this.novcanaKazna = novcanaKazna;
        this.brojKaznenihBodova = brojKaznenihBodova;
        this.duzinaZatvorskeKazne = duzinaZatvorskeKazne;
        this.datum = LocalDateTime.now();
    }

    public Kazna(String id, String registarskiBrojVozila, String brojVozackeDozvole, double novcanaKazna, double brojKaznenihBodova, double duzinaZatvorskeKazne) {
        this.id = id;
        this.registarskiBrojVozila = registarskiBrojVozila;
        this.brojVozackeDozvole = brojVozackeDozvole;
        this.novcanaKazna = novcanaKazna;
        this.brojKaznenihBodova = (int)brojKaznenihBodova;
        this.duzinaZatvorskeKazne = (int)duzinaZatvorskeKazne;
        this.datum = LocalDateTime.now();
    }

    // ovo je konstruktor samo kad se pravi za vozenje bez vozacke
    public Kazna(String registarskiBrojVozila, String brojVozackeDozvole, double novcanaKazna, double brojKaznenihBodova, double duzinaZatvorskeKazne) {
        this.registarskiBrojVozila = registarskiBrojVozila;
        this.brojVozackeDozvole = brojVozackeDozvole;
        this.novcanaKazna = novcanaKazna;
        this.brojKaznenihBodova = (int)brojKaznenihBodova;
        this.duzinaZatvorskeKazne = (int)duzinaZatvorskeKazne;
        this.datum = LocalDateTime.now();
    }

    // ovaj konstruktor sluzi samo za testiranje rada fronta
    public Kazna(String registarskiBrojVozila, String brojVozackeDozvole, double novcanaKazna,
                 double brojKaznenihBodova, double duzinaZatvorskeKazne, boolean istekla, boolean placena) {
        this.registarskiBrojVozila = registarskiBrojVozila;
        this.brojVozackeDozvole = brojVozackeDozvole;
        this.novcanaKazna = novcanaKazna;
        this.brojKaznenihBodova = (int)brojKaznenihBodova;
        this.duzinaZatvorskeKazne = (int)duzinaZatvorskeKazne;
        this.datum = LocalDateTime.now();
        this.istekla = istekla;
        if (placena)
        {
            this.vremePlacanja = LocalDateTime.now();
        }
    }

}
