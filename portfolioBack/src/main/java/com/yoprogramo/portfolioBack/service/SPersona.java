
package com.yoprogramo.portfolioBack.service;

import com.yoprogramo.portfolioBack.model.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yoprogramo.portfolioBack.repository.IRPersona;

@Service
public class SPersona {

    @Autowired
    IRPersona rPersona;
    
    public List<Persona> getAll() {
        return rPersona.findAll();
    }
    
    public Persona getById(int id) {
        return rPersona.findById(id).orElse(null);
    }

    public void save(Persona per) {
        rPersona.save(per);
    }

    public void deleteById(int id) {
        rPersona.deleteById(id);
    }
}
