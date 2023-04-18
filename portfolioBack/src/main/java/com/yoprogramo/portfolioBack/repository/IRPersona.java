
package com.yoprogramo.portfolioBack.repository;

import com.yoprogramo.portfolioBack.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRPersona extends JpaRepository <Persona, Long> {
    
}
