package com.ftn.sbnz.model;

import org.kie.api.definition.type.Position;

public class Brod {
    
    @Position(0)
    private String nazivBroda;

    @Position(1)
    private String tipBroda;

    public Brod() {
    }
    public Brod(String nazivBroda, String tipBroda) {
        this.nazivBroda = nazivBroda;
        this.tipBroda = tipBroda;
    }
    public String getNazivBroda() {
        return nazivBroda;
    }
    public void setNazivBroda(String nazivBroda) {
        this.nazivBroda = nazivBroda;
    }
    public String getTipBroda() {
        return tipBroda;
    }
    public void setTipBroda(String tipBroda) {
        this.tipBroda = tipBroda;
    }

    

}
