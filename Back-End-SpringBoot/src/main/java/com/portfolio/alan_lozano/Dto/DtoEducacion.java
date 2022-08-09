/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.alan_lozano.Dto;

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
    
    //constructor

    public DtoEducacion() {
    }
    
    public DtoEducacion(String nombreE, String tituloE, String descripcionE, int inicioE, int finE, String imgE) {
        this.nombreE = nombreE;
        this.tituloE = tituloE;
        this.descripcionE = descripcionE;
        this.inicioE = inicioE;
        this.finE = finE;
        this.imgE = imgE;
    }
    
    //getters y setters

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
