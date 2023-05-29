package com.ftn.sbnz.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vozac extends Korisnik {
    private String brojVozackeDozvole;
    private int brojOduzimanjeVozacke;
    private boolean vjecnoBlokiran = false;
//    private List<OduzimanjeVozacke> oduzimanjaVozacke;
//    private List<Kazna> kazne;
    // TODO ovdje ce mozda biti samo jedno vozilo
//    private List<Vozilo> vozila;
    public Vozac (String brojVozacke, String ime, String prezime, String email, String sifra, int brojOduzimanjeVozacke)
    {
        this.brojVozackeDozvole = brojVozacke;
        this.ime = ime;
        this.prezime = prezime;
        this.brojOduzimanjeVozacke = brojOduzimanjeVozacke;
        this.uloga = Role.VOZAC;
        this.email = email;
        this.sifra = sifra;
    }

    public void povecajBrojOduzimanjaVozacke()
    {
        this.brojOduzimanjeVozacke++;
    }


}
