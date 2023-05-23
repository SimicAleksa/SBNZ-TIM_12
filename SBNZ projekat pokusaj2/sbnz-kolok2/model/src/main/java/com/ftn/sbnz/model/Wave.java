package com.ftn.sbnz.model;

import java.io.Serializable;

import org.kie.api.definition.type.Role;

@Role(Role.Type.EVENT)
public class Wave implements Serializable{

    private static final long serialVersionUID = 1L;
    private int waveId;
    private int waveH;

    
    public Wave() {
    }
    
    public Wave(int waveId, int waveH) {
        this.waveId = waveId;
        this.waveH = waveH;
    }

    public void setWaveId(int waveId) {
        this.waveId = waveId;
    }
    public void setWaveH(int waveH) {
        this.waveH = waveH;
    }
    public int getWaveId() {
        return waveId;
    }
    public int getWaveH() {
        return waveH;
    }

    
}
