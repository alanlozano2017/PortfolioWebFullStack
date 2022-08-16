/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.alan_lozano.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "varchar(255) default 'Proyecto'")
    private String nombreP;
    @Column(columnDefinition = "varchar(1000) default ''")
    private String descripcionP;
    @Column(columnDefinition = "varchar(255) default '#'")
    private String urlP ="#";
    @Column(columnDefinition = "varchar(255) default '../assets/proyectos/imgdefault.jpg'")
    private String imgP = "../assets/proyectos/imgdefault.jpg";
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="persona_id", nullable=false)
    private Persona persona;
    
    public Proyecto() {
    }

    public Proyecto(String nombreP, String descripcionP, String urlP, String imgP) {
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
        this.urlP = urlP;
        this.imgP = imgP;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
