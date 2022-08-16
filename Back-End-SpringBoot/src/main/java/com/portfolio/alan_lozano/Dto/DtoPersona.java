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
public class DtoPersona {

    private String nombre;
    private String apellido;
    private String descripcionP;
    private String tituloP;
    private String img;
    private String pais;
    private String ubicacion;

    public DtoPersona() {
    }

    public DtoPersona(String nombre, String apellido, String descripcionP, String tituloP, String img, String pais, String ubicacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcionP = descripcionP;
        this.tituloP = tituloP;
        this.img = img;
        this.pais = pais;
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }

    public String getTituloP() {
        return tituloP;
    }

    public void setTituloP(String tituloP) {
        this.tituloP = tituloP;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    
}
