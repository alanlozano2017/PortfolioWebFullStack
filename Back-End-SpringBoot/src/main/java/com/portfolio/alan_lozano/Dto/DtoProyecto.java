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
public class DtoProyecto {
    private String nombreP;
    private String descripcionP;
    private String urlP;
    private String imgP;
    private int persona_fk;

    

    public DtoProyecto() {
    }

    public DtoProyecto(String nombreP, String descripcionP, String urlP, String imgP,int persona_fk) {
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
        this.urlP = urlP;
        this.imgP = imgP;
        this.persona_fk = persona_fk;
    }
    
    public int getPersona_fk() {
        return persona_fk;
    }

    public void setPersona_fk(int persona_fk) {
        this.persona_fk = persona_fk;
    }
    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }

    public String getUrlP() {
        return urlP;
    }

    public void setUrlP(String urlP) {
        this.urlP = urlP;
    }

    public String getImgP() {
        return imgP;
    }

    public void setImgP(String imgP) {
        this.imgP = imgP;
    }
    
    
}
