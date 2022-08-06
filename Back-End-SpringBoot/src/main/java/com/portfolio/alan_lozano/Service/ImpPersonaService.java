
package com.portfolio.alan_lozano.Service;

import com.portfolio.alan_lozano.Entity.Persona;
import com.portfolio.alan_lozano.Interface.IPersonaService;
import com.portfolio.alan_lozano.Repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpPersonaService implements IPersonaService {

    @Autowired IPersonaRepository ipersonaRepository;
    
    @Override
    public List<Persona> gerPersonas() {
        List<Persona> listaPersonas = ipersonaRepository.findAll();
        return listaPersonas;
    }

    @Override
    public void savePersona(Persona persona) {
        ipersonaRepository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        ipersonaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = ipersonaRepository.findById(id).orElse(null);
        return persona;
    }
    
}
