
package com.portfolio.alan_lozano.Controller;

import com.portfolio.alan_lozano.Dto.DtoExperiencia;
import com.portfolio.alan_lozano.Entity.Experiencia;
import com.portfolio.alan_lozano.Entity.Persona;
import com.portfolio.alan_lozano.Security.Controller.Mensaje;
import com.portfolio.alan_lozano.Service.ImpPersonaService;
import com.portfolio.alan_lozano.Service.SExperiencia;
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
@RequestMapping("explab")
@CrossOrigin(origins = "http://localhost:4200")
public class CExperiencia {
    @Autowired
    SExperiencia sExperiencia;
    @Autowired
    ImpPersonaService sPersona;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = sExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!sExperiencia.existsById(id)){
            return new ResponseEntity(new Mensaje("experiencia no existe"), HttpStatus.NOT_FOUND);
        }
        Experiencia experiencia = sExperiencia.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoExperiencia dtoexp){
        int persId = dtoexp.getPersona_fk();
        if(StringUtils.isBlank(dtoexp.getNombreE())){
            return new ResponseEntity(new Mensaje("el nombre de la experiencia es obligatorio"), HttpStatus.BAD_REQUEST);
        }
//        if(sExperiencia.existsByNombreE(dtoexp.getNombreE())){
//            return new ResponseEntity(new Mensaje("esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
//        }
        Persona persona = sPersona.findPersona(persId);
        
        Experiencia experiencia = new Experiencia(dtoexp.getNombreE(), dtoexp.getDescripcionE());
        
        experiencia.setPersona(persona);
        
        sExperiencia.save(experiencia);

        persona.addExperiencias(experiencia);
        
        sPersona.savePersona(persona);
        
        return new ResponseEntity(new Mensaje("experiencia agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExperiencia dtoexp){
        //valida si existe el ID
        if(!sExperiencia.existsById(id)){
            return new ResponseEntity(new Mensaje("el id no existe"+id), HttpStatus.NOT_FOUND);
        }
        //compara nombre de experiencias
        /*if (sExperiencia.existsByNombreE(dtoexp.getNombreE()) 
            && sExperiencia.getByNombreE(dtoexp.getNombreE()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }*/
        //no puede estar vacio
        if (StringUtils.isBlank(dtoexp.getNombreE())) {
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Experiencia experiencia = sExperiencia.getOne(id).get();
        experiencia.setNombreE(dtoexp.getNombreE());
        experiencia.setDescripcionE(dtoexp.getDescripcionE());
        
        
        sExperiencia.save(experiencia);
        return new ResponseEntity(new Mensaje("experiencia actualizada"), HttpStatus.OK);
        
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        //valida si existe el ID
        if(!sExperiencia.existsById(id)){
            return new ResponseEntity(new Mensaje("el id no existe"), HttpStatus.NOT_FOUND);
        }
        
        sExperiencia.delete(id);
        
        return new ResponseEntity(new Mensaje("experiencia eliminada"), HttpStatus.OK);

    }
    

    
}
