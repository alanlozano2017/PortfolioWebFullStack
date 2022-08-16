
package com.portfolio.alan_lozano.Dto;

import javax.validation.constraints.NotBlank;


public class DtoExperiencia {
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;
    private int persona_fk;
    
    //constructor


    public DtoExperiencia() {
    }

    public DtoExperiencia(String nombreE, String descripcionE, int persona_fk) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.persona_fk = persona_fk;
    }
    
    //getters y setters
    
    public int getPersona_fk() {
        return persona_fk;
    }

    public void setPersona_fk(int persona_fk) {
        this.persona_fk = persona_fk;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }
    
    
    
    
    
    
}
