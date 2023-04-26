
package com.yoprogramo.portfolioBack.service;

import com.yoprogramo.portfolioBack.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yoprogramo.portfolioBack.repository.IRPersona;
import java.util.Optional;

@Service
public class SPersona {

    @Autowired
    IRPersona rPersona;

    public Optional<Persona> getById(int id) {
        return rPersona.findById(id);
    }

    public void save(Persona per) {
        rPersona.save(per);
    }
    
    public boolean existsById(int id){
        return rPersona.existsById(id);
    }
}
