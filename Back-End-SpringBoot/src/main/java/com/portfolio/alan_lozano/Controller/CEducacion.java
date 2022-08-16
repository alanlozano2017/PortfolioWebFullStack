/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.alan_lozano.Controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.portfolio.alan_lozano.Dto.DtoEducacion;
import com.portfolio.alan_lozano.Entity.Educacion;
import com.portfolio.alan_lozano.Entity.Persona;
import com.portfolio.alan_lozano.Security.Controller.Mensaje;
import com.portfolio.alan_lozano.Service.ImpPersonaService;
import com.portfolio.alan_lozano.Service.SEducacion;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("educacion")
@CrossOrigin(origins = "https://app-lozano-front.web.app")
public class CEducacion {
    @Autowired
    SEducacion sEducacion;
    @Autowired
    ImpPersonaService sPersona;
    @PreAuthorize("permitAll()") 
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = sEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("experiencia no existe"), HttpStatus.NOT_FOUND);
        }
        Educacion educacion = sEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    @PostMapping("/create/")
    public ResponseEntity<?> create(@RequestBody DtoEducacion dtoedu){
        int persId = dtoedu.getPersona_fk();
        if(StringUtils.isBlank(dtoedu.getNombreE())){
            return new ResponseEntity(new Mensaje("el nombre de la educacion es obligatorio"), HttpStatus.BAD_REQUEST);
        }

//        if(sEducacion.existsByNombreE(dtoedu.getNombreE())){
//            return new ResponseEntity(new Mensaje("esa educacion ya existe"), HttpStatus.BAD_REQUEST);
//        }
        
        //System.out.println("id prueba" + dtoedu.getPersona().getId()+ "tipo variable");
        Persona persona = sPersona.findPersona(persId);
        
        Educacion educacion = new Educacion(dtoedu.getNombreE(), dtoedu.getTituloE(), dtoedu.getDescripcionE(), dtoedu.getInicioE(), dtoedu.getFinE(), dtoedu.getImgE());
        if(dtoedu.getImgE()==""){
            educacion.setImgE("../assets/logos/default.png");
        }
        educacion.setPersona(persona);
        
        sEducacion.save(educacion);
        
        persona.addEducaciones(educacion);
        
        sPersona.savePersona(persona);

        return new ResponseEntity(new Mensaje("educacion agregada "+dtoedu.toString()), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEducacion dtoedu){
        //valida si existe el ID
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("el id no existe"+id), HttpStatus.NOT_FOUND);
        }
        //compara nombre de educaciones
        /*if (sEducacion.existsByNombreE(dtoedu.getNombreE()) 
            && sEducacion.getByNombreE(dtoedu.getNombreE()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("esa educacion ya existe"), HttpStatus.BAD_REQUEST);
        }*/
        //no puede estar vacio
        if (StringUtils.isBlank(dtoedu.getNombreE())) {
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion = sEducacion.getOne(id).get();
        educacion.setNombreE(dtoedu.getNombreE());
        educacion.setTituloE(dtoedu.getTituloE());
        educacion.setDescripcionE(dtoedu.getDescripcionE());
        educacion.setInicioE(dtoedu.getInicioE());
        educacion.setFinE(dtoedu.getFinE());
        if(dtoedu.getImgE()==""){
            educacion.setImgE("../assets/logos/default.png");
        }else{
            educacion.setImgE(dtoedu.getImgE());
        }
        
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("educacion actualizada"), HttpStatus.OK);
        
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        //valida si existe el ID
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("el id no existe"), HttpStatus.NOT_FOUND);
        }
        
        sEducacion.delete(id);
        
        return new ResponseEntity(new Mensaje("educacion eliminada"), HttpStatus.OK);

    }
    
    
    
}
