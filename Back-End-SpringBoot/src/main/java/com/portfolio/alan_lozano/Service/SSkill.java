/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.alan_lozano.Service;

import com.portfolio.alan_lozano.Entity.Skill;
import com.portfolio.alan_lozano.Repository.RSkill;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SSkill {
    @Autowired
    RSkill rSkill;
    
    public List<Skill> list(){
        return rSkill.findAll();
    }
    
    public Optional<Skill> getOne(int id){
        return rSkill.findById(id);
    }
    
    public Optional<Skill> getByNombreS(String nombreS){
        return rSkill.findByNombreS(nombreS);
    }
    
    public void save(Skill skill){
        rSkill.save(skill);
    }
    
    public void delete(int id){
        rSkill.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rSkill.existsById(id);
    }
    
    public boolean existsByNombreE(String nombreS){
        return rSkill.existsByNombreS(nombreS);
    }
    
    
}