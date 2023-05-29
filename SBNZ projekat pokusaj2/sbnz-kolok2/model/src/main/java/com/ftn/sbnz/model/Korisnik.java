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
public class Korisnik {
    @Id
    protected String id;
    protected String ime;
    protected String prezime;
    protected String email;
    protected String sifra;
    protected Role uloga;
}
