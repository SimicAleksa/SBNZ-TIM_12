package com.ftn.sbnz.model;

public class Admin extends Korisnik{

    public Admin(String ime, String prezime, String email, String sifra)
    {
        this.ime = ime;
        this.prezime = prezime;
        this.uloga = Role.ADMIN;
        this.email = email;
        this.sifra = sifra;
    }


}
