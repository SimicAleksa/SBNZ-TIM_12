package com.ftn.sbnz.model;

public class ParametriZaNaseljeIVreme {
    private String vrstaLokacije;
    private double visinaOgranicenja;
    private String vrstaVremena;
    private double procenatUmanjenjaBrzine;

    public ParametriZaNaseljeIVreme() {
    }

    public ParametriZaNaseljeIVreme(String vrstaLokacije, double visinaOgranicenja, String vrstaVremena, double procenatUmanjenjaBrzine) {
        this.vrstaLokacije = vrstaLokacije;
        this.visinaOgranicenja = visinaOgranicenja;
        this.vrstaVremena = vrstaVremena;
        this.procenatUmanjenjaBrzine = procenatUmanjenjaBrzine;
    }

    public String getVrstaLokacije() {
        return vrstaLokacije;
    }

    public void setVrstaLokacije(String vrstaLokacije) {
        this.vrstaLokacije = vrstaLokacije;
    }

    public double getVisinaOgranicenja() {
        return visinaOgranicenja;
    }

    public void setVisinaOgranicenja(double visinaOgranicenja) {
        this.visinaOgranicenja = visinaOgranicenja;
    }

    public String getVrstaVremena() {
        return vrstaVremena;
    }

    public void setVrstaVremena(String vrstaVremena) {
        this.vrstaVremena = vrstaVremena;
    }

    public double getProcenatUmanjenjaBrzine() {
        return procenatUmanjenjaBrzine;
    }

    public void setProcenatUmanjenjaBrzine(double procenatUmanjenjaBrzine) {
        this.procenatUmanjenjaBrzine = procenatUmanjenjaBrzine;
    }
}
