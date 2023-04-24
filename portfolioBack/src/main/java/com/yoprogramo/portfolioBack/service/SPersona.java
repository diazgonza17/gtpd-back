
package com.yoprogramo.portfolioBack.service;

import com.yoprogramo.portfolioBack.model.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yoprogramo.portfolioBack.repository.IRPersona;
import java.util.Optional;

@Service
public class SPersona {

    @Autowired
    IRPersona rPersona;
    
    public List<Persona> getAll() {
        return rPersona.findAll();
    }
    
    public Optional<Persona> getById(int id) {
        return rPersona.findById(id);
    }
    
    public Optional<Persona> getByNombre(String nombre){
        return rPersona.findByNombre(nombre);
    }

    public void save(Persona per) {
        rPersona.save(per);
    }

    public void deleteById(int id) {
        rPersona.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rPersona.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return rPersona.existsByNombre(nombre);
    }
}
