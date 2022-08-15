/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.alan_lozano.Controller;


import com.portfolio.alan_lozano.Dto.DtoProyecto;
import com.portfolio.alan_lozano.Entity.Persona;
import com.portfolio.alan_lozano.Entity.Proyecto;
import com.portfolio.alan_lozano.Security.Controller.Mensaje;
import com.portfolio.alan_lozano.Service.ImpPersonaService;
import com.portfolio.alan_lozano.Service.SProyecto;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("proyecto")
@CrossOrigin(origins = "http://localhost:4200")
public class CProyecto {
    @Autowired
    SProyecto sProyecto;
    @Autowired
    ImpPersonaService sPersona;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list(){
        List<Proyecto> list = sProyecto.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id){
        if(!sProyecto.existsById(id)){
            return new ResponseEntity(new Mensaje("Proyecto no existe"), HttpStatus.NOT_FOUND);
        }
        Proyecto proyecto = sProyecto.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoProyecto dtoproyecto){
        int persId = dtoproyecto.getPersona_fk();
        if(StringUtils.isBlank(dtoproyecto.getNombreP())){
            return new ResponseEntity(new Mensaje("el nombre del proyecto es obligatorio"), HttpStatus.BAD_REQUEST);
        }
//        if(sEducacion.existsByNombreE(dtoedu.getNombreE())){
//            return new ResponseEntity(new Mensaje("esa educacion ya existe"), HttpStatus.BAD_REQUEST);
//        }
        Persona persona = sPersona.findPersona(persId);


        Proyecto proyecto = new Proyecto(dtoproyecto.getNombreP(), dtoproyecto.getDescripcionP(), dtoproyecto.getUrlP(), dtoproyecto.getImgP());
        if(dtoproyecto.getUrlP()==""){
            proyecto.setUrlP("#");
        }
        if(dtoproyecto.getImgP()==""){
            proyecto.setImgP("../assets/proyectos/imgdefault.jpg");
        }
        proyecto.setPersona(persona);
        
        sProyecto.save(proyecto);
        
        persona.addProyectos(proyecto);
        
        sPersona.savePersona(persona);
        
        return new ResponseEntity(new Mensaje("proyecto agregado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProyecto dtoproyecto){
        //valida si existe el ID
        if(!sProyecto.existsById(id)){
            return new ResponseEntity(new Mensaje("el id no existe"+id), HttpStatus.NOT_FOUND);
        }
        //compara nombre de educaciones
        /*if (sEducacion.existsByNombreE(dtoedu.getNombreE()) 
            && sEducacion.getByNombreE(dtoedu.getNombreE()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("esa educacion ya existe"), HttpStatus.BAD_REQUEST);
        }*/
        //no puede estar vacio
        if (StringUtils.isBlank(dtoproyecto.getNombreP())) {
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Proyecto proyecto = sProyecto.getOne(id).get();
        proyecto.setNombreP(dtoproyecto.getNombreP());
        proyecto.setDescripcionP(dtoproyecto.getDescripcionP());
        if(dtoproyecto.getUrlP()==""){
            proyecto.setUrlP("#");
        } else{
            proyecto.setUrlP(dtoproyecto.getUrlP());
        }
        if(dtoproyecto.getImgP()==""){
            proyecto.setImgP("../assets/proyectos/imgdefault.jpg");
        } else{
            proyecto.setImgP(dtoproyecto.getImgP());
        }


        
        sProyecto.save(proyecto);
        return new ResponseEntity(new Mensaje("proyecto actualizada"), HttpStatus.OK);
        
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        //valida si existe el ID
        if(!sProyecto.existsById(id)){
            return new ResponseEntity(new Mensaje("el id no existe"), HttpStatus.NOT_FOUND);
        }
        
        sProyecto.delete(id);
        
        return new ResponseEntity(new Mensaje("educacion eliminada"), HttpStatus.OK);

    }
    
    
    
}