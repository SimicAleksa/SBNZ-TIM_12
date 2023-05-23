package com.ftn.sbnz.model;

public class ParametriZaKaznu {
    private String vrstaLokacije;
    private double donjaGranicaPrekoracenja;
    private double gornjaGranicaPrekoracenja;
    private double donjaGranicaNovcaneKazne;
    private double gornjaGranicaNovcaneKazne;
    private int brojKaznenihPoena;
    private int duzinaZatvorskeKazne;

    public ParametriZaKaznu() {
    }

    public ParametriZaKaznu(String tipLokacije, double donjaGranicaPrekoracenja, double gornjaGranicaPrekoracenja, double donjaGranicaNovcaneKazne, double gornjaGranicaNovcaneKazne, int brojKaznenihPoena, int duzinaZatvorskeKazne) {
        this.vrstaLokacije = tipLokacije;
        this.donjaGranicaPrekoracenja = donjaGranicaPrekoracenja;
        this.gornjaGranicaPrekoracenja = gornjaGranicaPrekoracenja;
        this.donjaGranicaNovcaneKazne = donjaGranicaNovcaneKazne;
        this.gornjaGranicaNovcaneKazne = gornjaGranicaNovcaneKazne;
        this.brojKaznenihPoena = brojKaznenihPoena;
        this.duzinaZatvorskeKazne = duzinaZatvorskeKazne;
    }

    public String getVrstaLokacije() {
        return vrstaLokacije;
    }

    public void setVrstaLokacije(String vrstaLokacije) {
        this.vrstaLokacije = vrstaLokacije;
    }

    public double getDonjaGranicaPrekoracenja() {
        return donjaGranicaPrekoracenja;
    }

    public void setDonjaGranicaPrekoracenja(double donjaGranicaPrekoracenja) {
        this.donjaGranicaPrekoracenja = donjaGranicaPrekoracenja;
    }

    public double getGornjaGranicaPrekoracenja() {
        return gornjaGranicaPrekoracenja;
    }

    public void setGornjaGranicaPrekoracenja(double gornjaGranicaPrekoracenja) {
        this.gornjaGranicaPrekoracenja = gornjaGranicaPrekoracenja;
    }

    public double getGornjaGranicaNovcaneKazne() {
        return gornjaGranicaNovcaneKazne;
    }

    public void setGornjaGranicaNovcaneKazne(double gornjaGranicaNovcaneKazne) {
        this.gornjaGranicaNovcaneKazne = gornjaGranicaNovcaneKazne;
    }

    public double getDonjaGranicaNovcaneKazne() {
        return donjaGranicaNovcaneKazne;
    }

    public void setDonjaGranicaNovcaneKazne(double donjaGranicaNovcaneKazne) {
        this.donjaGranicaNovcaneKazne = donjaGranicaNovcaneKazne;
    }

    public double getBrojKaznenihPoena() {
        return brojKaznenihPoena;
    }

    public void setBrojKaznenihPoena(int brojKaznenihPoena) {
        this.brojKaznenihPoena = brojKaznenihPoena;
    }

    public double getDuzinaZatvorskeKazne() {
        return duzinaZatvorskeKazne;
    }

    public void setDuzinaZatvorskeKazne(int duzinaZatvorskeKazne) {
        this.duzinaZatvorskeKazne = duzinaZatvorskeKazne;
    }
}
