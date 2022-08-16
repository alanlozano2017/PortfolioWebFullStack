/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.alan_lozano.Repository;


import com.portfolio.alan_lozano.Entity.Skill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RSkill extends JpaRepository<Skill, Integer> {
    public Optional<Skill> findByNombreS(String nombreS);
    public boolean existsByNombreS(String nombreS);
    

}