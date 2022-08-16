/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.alan_lozano.Repository;

import com.portfolio.alan_lozano.Entity.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RProyecto extends JpaRepository<Proyecto, Integer> {
    public Optional<Proyecto> findByNombreP(String nombreP);
    public boolean existsByNombreP(String nombreP);
    
    
    
}