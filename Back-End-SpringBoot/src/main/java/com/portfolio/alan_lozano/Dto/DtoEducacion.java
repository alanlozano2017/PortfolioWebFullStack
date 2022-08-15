/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.alan_lozano.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.portfolio.alan_lozano.Entity.Persona;
import javax.validation.constraints.NotBlank;


public class DtoEducacion {
    
    @NotBlank
    private String nombreE;
    @NotBlank
    private String tituloE;
    private String descripcionE;
    private int inicioE;
    private int finE;
    private String imgE;
    private int persona_fk;

    //private Persona persona;

    
    
    
    //constructor

    public DtoEducacion() {
    }
    
    public DtoEducacion(String nombreE, String tituloE, String descripcionE, int inicioE, int finE, String imgE, int persona_fk) {
        this.nombreE = nombreE;
        this.tituloE = tituloE;
        this.descripcionE = descripcionE;
        this.inicioE = inicioE;
        this.finE = finE;
        this.imgE = imgE;
        this.persona_fk = persona_fk;
    }

    @Override
    public String toString() {
        return "DtoEducacion{" + "nombreE=" + nombreE + ", tituloE=" + tituloE + ", descripcionE=" + descripcionE + ", inicioE=" + inicioE + ", finE=" + finE + ", imgE=" + imgE + ", persona_fk=" + persona_fk + '}';
    }

    
    //getters y setters
    
    public int getPersona_fk() {
        return persona_fk;
    }

    public void setPersona_fk(int persona_fk) {
        this.persona_fk = persona_fk;
    }
    
//    public void setPersona(Persona persona){
//        this.persona = persona;
//    }
//    public Persona getPersona(){
//        return this.persona;
//    }



    
    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getTituloE() {
        return tituloE;
    }

    public void setTituloE(String tituloE) {
        this.tituloE = tituloE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public int getInicioE() {
        return inicioE;
    }

    public void setInicioE(int inicioE) {
        this.inicioE = inicioE;
    }

    public int getFinE() {
        return finE;
    }

    public void setFinE(int finE) {
        this.finE = finE;
    }

    public String getImgE() {
        return imgE;
    }

    public void setImgE(String imgE) {
        this.imgE = imgE;
    }

    

    
    
    
    
    
}
