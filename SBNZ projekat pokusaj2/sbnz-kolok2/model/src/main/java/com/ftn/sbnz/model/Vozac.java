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
public class Vozac {
    @Id
    private String id;
    private String ime;
    private String prezime;
    private int brojOduzimanjeVozacke;
    private List<OduzimanjeVozacke> oduzimanjaVozacke;
    private List<Kazna> kazne;
    // TODO ovdje ce mozda biti samo jedno vozilo
    private List<Vozilo> vozila;


}
