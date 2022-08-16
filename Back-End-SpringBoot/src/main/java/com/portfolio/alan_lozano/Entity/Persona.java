
package com.portfolio.alan_lozano.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String nombre;
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String apellido;
    @Column(columnDefinition = "varchar(1000)")
    private String descripcionP;
    @Column(columnDefinition = "varchar(255) default 'Desarrollador Web Fuull Stack'")
    private String tituloP;
    @Column(columnDefinition = "varchar(255) default '../assets/skills/default.png'")
    private String img;
    private String pais;
    private String ubicacion;
    @JsonIgnore
    @OneToMany( mappedBy = "persona")
    private List<Experiencia> experiencias;
    @JsonIgnore
    @OneToMany( mappedBy = "persona")
    private List<Educacion> educaciones;
    @JsonIgnore
    @OneToMany( mappedBy = "persona")
    private List<Skill> skills;
    @JsonIgnore
    @OneToMany( mappedBy = "persona")
    private List<Proyecto> proyectos;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String descripcionP, String tituloP, String img, String pais, String ubicacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcionP = descripcionP;
        this.tituloP = tituloP;
        this.img = img;
        this.pais = pais;
        this.ubicacion = ubicacion;
    }

    
    

    public void addExperiencias(Experiencia experiencia) {
        if(experiencia != null ){
            if (experiencias == null){
                experiencias = new ArrayList<>();
            }
            experiencias.add(experiencia);
            //experiencia.setPersona(this);
        }
    }
    
    public void addEducaciones(Educacion educacion) {
        if(educacion != null ){
        if (educaciones == null){
            educaciones = new ArrayList<>();
        }
        educaciones.add(educacion);
        //educacion.setPersona(this);
        }
    }
    
    public void addSkills(Skill skill) {
        if(skill != null ){
        if (skills == null){
            skills = new ArrayList<>();
        }
        skills.add(skill);
        //skill.setPersona(this);
        }
    }
    
    public void addProyectos(Proyecto proyecto) {
        if(proyecto != null ){
        if (proyectos == null){
            proyectos = new ArrayList<>();
        }
        proyectos.add(proyecto);
        //proyecto.setPersona(this);
        }
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
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Experiencia> getExperiencias() {
        return experiencias;
    }

    public void setExperiencias(List<Experiencia> experiencias) {
        this.experiencias = experiencias;
    }
    

    public List<Educacion> getEducaciones() {
        return educaciones;
    }

    public void setEducaciones(List<Educacion> educaciones) {
        this.educaciones = educaciones;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    
    
    
    
}
