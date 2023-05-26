package com.ftn.sbnz.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
public class IzvrsiteljskiPostupak {
    private String idKazne;
    private String brojVozackeDozvole;
    private double iznos;
    //private LocalDateTime datum;

    public IzvrsiteljskiPostupak(String idKazne, String brVoz, double iznos)
    {
        this.idKazne = idKazne;
        this.brojVozackeDozvole = brVoz;
        this.iznos = iznos;
        //this.datum = LocalDateTime.now();
    }


}
