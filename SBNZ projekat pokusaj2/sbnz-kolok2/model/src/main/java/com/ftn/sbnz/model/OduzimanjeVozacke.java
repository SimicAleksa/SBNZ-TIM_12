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
public class OduzimanjeVozacke implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String brojVozackeDozvole;
    private LocalDateTime datum;
    private int brojMeseci;

    public OduzimanjeVozacke(String brojVozacke, int brojMeseci)
    {
        this.brojVozackeDozvole = brojVozacke;
        this.brojMeseci = brojMeseci;
        this.datum = LocalDateTime.now();
    }


}
