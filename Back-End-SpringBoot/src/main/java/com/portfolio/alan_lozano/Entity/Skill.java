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
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //../assets/skills/default.png
    @Column(columnDefinition = "varchar(255) default ''")
    private String nombreS;
    @Column(columnDefinition = "varchar(255) default ''")
    private String imgS= "../assets/logos/default.png";
    @Column(columnDefinition = "integer default 0")
    private int progress;
    @Column(columnDefinition = "boolean default false")
    private boolean type;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="persona_id", nullable=false)
    private Persona persona;
    
    //constructores
    public Skill() {
    }

    public Skill(String nombreS, String imgS, int progress, boolean type) {
        this.nombreS = nombreS;
        this.imgS = imgS;
        this.progress = progress;
        this.type = type;
    }

    //getters y setters
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

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    
    
    
}
