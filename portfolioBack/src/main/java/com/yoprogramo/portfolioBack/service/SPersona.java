
package com.yoprogramo.portfolioBack.service;

import com.yoprogramo.portfolioBack.model.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yoprogramo.portfolioBack.repository.IRPersona;

@Service
public class SPersona implements ISPersona {

    @Autowired
    IRPersona rPersona;
    
    @Override
    public List<Persona> verPersonas() {
        return rPersona.findAll();
    }

    @Override
    public void crearPersona(Persona per) {
        rPersona.save(per);
    }

    @Override
    public void borrarPersona(Long id) {
        rPersona.deleteById(id);
    }

    @Override
    public Persona buscarPersona(Long id) {
        return rPersona.findById(id).orElse(null);
    }
    
}
