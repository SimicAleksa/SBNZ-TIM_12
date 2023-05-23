package com.ftn.sbnz.model;

public class Boat {
    private int boatId;
    private int boatH;
    public Boat() {
    }
    public Boat(int boatId) {
        this.boatId = boatId;
        this.boatH = 4;
    }
    public int getBoatId() {
        return boatId;
    }
    public void setBoatId(int boatId) {
        this.boatId = boatId;
    }
    public int getBoatH() {
        return boatH;
    }
    public void setBoatH(int boatH) {
        this.boatH = boatH;
    }
}
