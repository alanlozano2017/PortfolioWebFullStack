/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.alan_lozano.Dto;

/**
 *
 * @author Alan
 */
public class DtoSkill {
    private String nombreS;
    private String imgS;
    private int progress;
    private boolean type;


    //constructor

    public DtoSkill() {
    }

    public DtoSkill(String nombreS, String imgS, int progress, boolean type) {
        this.nombreS = nombreS;
        this.imgS = imgS;
        this.progress = progress;
        this.type = type;
        
    }
    
    //getters y setters
    
    

    public String getNombreS() {
        return nombreS;
    }

    public void setNombreS(String nombreS) {
        this.nombreS = nombreS;
    }

    public String getImgS() {
        return imgS;
    }

    public void setImgS(String imgS) {
        this.imgS = imgS;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public boolean getType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }
    
    
}
