/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.alan_lozano.Controller;


import com.portfolio.alan_lozano.Dto.DtoSkill;
import com.portfolio.alan_lozano.Entity.Persona;
import com.portfolio.alan_lozano.Entity.Skill;
import com.portfolio.alan_lozano.Security.Controller.Mensaje;
import com.portfolio.alan_lozano.Service.ImpPersonaService;
import com.portfolio.alan_lozano.Service.SSkill;
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
@RequestMapping("skill")
@CrossOrigin(origins = "https://app-lozano-front.web.app")
public class CSkill {
    @Autowired
    SSkill sSkill;
    @Autowired
    ImpPersonaService sPersona;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Skill>> list(){
        List<Skill> list = sSkill.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skill> getById(@PathVariable("id") int id){
        if(!sSkill.existsById(id)){
            return new ResponseEntity(new Mensaje("skill no existe"), HttpStatus.NOT_FOUND);
        }
        Skill skill = sSkill.getOne(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoSkill dtoskill){
        int persId = dtoskill.getPersona_fk();
        if(StringUtils.isBlank(dtoskill.getNombreS())){
            return new ResponseEntity(new Mensaje("el nombre de la skill es obligatorio"), HttpStatus.BAD_REQUEST);
        }
//        if(sEducacion.existsByNombreE(dtoedu.getNombreE())){
//            return new ResponseEntity(new Mensaje("esa educacion ya existe"), HttpStatus.BAD_REQUEST);
//        }
        Persona persona = sPersona.findPersona(persId);

        Skill skill = new Skill(dtoskill.getNombreS(), dtoskill.getImgS(), dtoskill.getProgress(), dtoskill.getType());
        
        if(dtoskill.getImgS()==""){
            skill.setImgS("../assets/logos/default.png");
        }
        skill.setPersona(persona);
        
        sSkill.save(skill);
        
        persona.addSkills(skill);
        
        sPersona.savePersona(persona);
        
        return new ResponseEntity(new Mensaje("skill agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoSkill dtoskill){
        //valida si existe el ID
        if(!sSkill.existsById(id)){
            return new ResponseEntity(new Mensaje("el id no existe"+id), HttpStatus.NOT_FOUND);
        }
        //compara nombre de educaciones
        /*if (sEducacion.existsByNombreE(dtoedu.getNombreE()) 
            && sEducacion.getByNombreE(dtoedu.getNombreE()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("esa educacion ya existe"), HttpStatus.BAD_REQUEST);
        }*/
        //no puede estar vacio
        if (StringUtils.isBlank(dtoskill.getNombreS())) {
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Skill skill = sSkill.getOne(id).get();
        skill.setNombreS(dtoskill.getNombreS());
        skill.setProgress(dtoskill.getProgress());
        skill.setType(dtoskill.getType());
        
        if(dtoskill.getImgS()==""){
            skill.setImgS("../assets/logos/default.png");
        } else{
            skill.setImgS(dtoskill.getImgS());
        }

        
        sSkill.save(skill);
        return new ResponseEntity(new Mensaje("skill actualizada"), HttpStatus.OK);
        
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        //valida si existe el ID
        if(!sSkill.existsById(id)){
            return new ResponseEntity(new Mensaje("el id no existe"), HttpStatus.NOT_FOUND);
        }
        
        sSkill.delete(id);
        
        return new ResponseEntity(new Mensaje("educacion eliminada"), HttpStatus.OK);

    }
    
    
    
}