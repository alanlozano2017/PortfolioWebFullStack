
package com.portfolio.alan_lozano.Interface;

import com.portfolio.alan_lozano.Entity.Persona;
import java.util.List;


public interface IPersonaService {
    //traer una lista de personas
    public List<Persona> gerPersonas();
    //guardar un objeto tipo Persona
    public void savePersona(Persona persona);
    //eliminar un objeto persona por id
    public void deletePersona(Long id);
    //buscar una persona por id
    public Persona findPersona(Long id);
    
}
