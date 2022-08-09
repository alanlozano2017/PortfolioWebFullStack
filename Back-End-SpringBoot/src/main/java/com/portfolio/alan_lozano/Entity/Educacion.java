/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.alan_lozano.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.lang.Nullable;

@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Nullable
    private String nombreE;
    @Nullable
    private String tituloE;
    @Nullable
    private String descripcionE;
    @Nullable
    private int inicioE;
    @Nullable
    private int finE;
    @Nullable
    private String imgE;

    public Educacion(String nombreE, String tituloE, String descripcionE, int inicioE, int finE, String imgE) {
        this.nombreE = nombreE;
        this.tituloE = tituloE;
        this.descripcionE = descripcionE;
        this.inicioE = inicioE;
        this.finE = finE;
        this.imgE = imgE;
    }
    
    //constructor

    public Educacion() {
    }

    //getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
