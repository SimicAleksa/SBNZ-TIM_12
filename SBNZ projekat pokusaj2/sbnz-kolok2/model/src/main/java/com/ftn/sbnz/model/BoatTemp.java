package com.ftn.sbnz.model;

public class BoatTemp {
    private int length;
    private int draft ;
    private int TEU ;
    private String type;
    public BoatTemp() {
    }

    public BoatTemp(int length, int draft, int TEU) {
        this.length = length;
        this.draft = draft;
        this.TEU = TEU;
    }

    public BoatTemp(int length, int draft, int TEU, String type) {
        this.length = length;
        this.draft = draft;
        this.TEU = TEU;
        this.type = type;
    }

    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public int getDraft() {
        return draft;
    }
    public void setDraft(int draft) {
        this.draft = draft;
    }
    public int getTEU() {
        return TEU;
    }
    public void setTEU(int TEU) {
        this.TEU = TEU;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    

    
    
}
