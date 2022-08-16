
package com.portfolio.alan_lozano.Controller;

import com.portfolio.alan_lozano.Dto.DtoPersona;
import com.portfolio.alan_lozano.Entity.Persona;
import com.portfolio.alan_lozano.Interface.IPersonaService;
import com.portfolio.alan_lozano.Security.Controller.Mensaje;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.lang3.StringUtils;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    @Autowired IPersonaService ipersonaService;
    
    @GetMapping("/personas/traer")
    public List<Persona> getPersonas(){
        return ipersonaService.gerPersonas();
    }
    @GetMapping("/personas/traer/perfil")
    public Persona findPersonas(){
        return ipersonaService.findPersona( 1);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "la persona fue creada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable int id){
        ipersonaService.deletePersona(id);
        return"la persona fue borrada correctamente";
    }
    
    //url:direccion/personas/editar/2?nombre=Mario&apellido=Bross&img=otraimg
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("personas/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoPersona dtopersona){
        //valida si existe el ID
        if(ipersonaService.findPersona(id)== null){
            return new ResponseEntity(new Mensaje("el id no existe"+id), HttpStatus.NOT_FOUND);
        }
        //compara nombre de educaciones
        /*if (sEducacion.existsByNombreE(dtoedu.getNombreE()) 
            && sEducacion.getByNombreE(dtoedu.getNombreE()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("esa educacion ya existe"), HttpStatus.BAD_REQUEST);
        }*/
        //no puede estar vacio
        if (StringUtils.isBlank(dtopersona.getNombre())) {
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        Persona persona = ipersonaService.findPersona(id);
        persona.setNombre(dtopersona.getNombre());
        persona.setApellido(dtopersona.getApellido());
        persona.setDescripcionP(dtopersona.getDescripcionP());
        persona.setTituloP(dtopersona.getTituloP());
        persona.setImg(dtopersona.getImg());
        if(dtopersona.getImg()==""){
            persona.setImg("../../../assets/imagenes/profile.jpg");
        }else{
            persona.setImg(dtopersona.getImg());
        }
        persona.setPais(dtopersona.getPais());
        persona.setUbicacion(dtopersona.getUbicacion());

        ipersonaService.savePersona(persona);
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
        
    }
    
//    public Persona editPersona(@PathVariable int id,
//                                @RequestParam("nombre") String nuevoNombre,
//                                @RequestParam("apellido") String nuevoApellido,
//                                @RequestParam("tituloP") String nuevotTitulo,
//                                @RequestParam("descripcionP") String nuevoDescripcion,
//                                @RequestParam("img") String nuevoImg,
//                                @RequestParam("pais") String nuevoPais,
//                                @RequestParam("ubicacion") String ubicacion
//                                ){
//        
//        Persona persona = ipersonaService.findPersona(id);
//        persona.setNombre(nuevoNombre);
//        persona.setApellido(nuevoApellido);
//        persona.setTituloP(nuevotTitulo);
//        persona.setDescripcionP(nuevoDescripcion);
//        persona.setImg(nuevoImg);
//        
//        ipersonaService.savePersona(persona);
//        return persona;
//    }
    
    
}
