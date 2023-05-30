package com.ftn.sbnz.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Korisnik implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    protected String id;
    protected String ime;
    protected String prezime;
    protected String email;
    protected String sifra;
    protected Role uloga;
}
