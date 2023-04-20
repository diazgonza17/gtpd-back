
package com.yoprogramo.portfolioBack.service;

import com.yoprogramo.portfolioBack.model.Experiencia;
import com.yoprogramo.portfolioBack.repository.IRExperiencia;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SExperiencia {
    
    @Autowired
    IRExperiencia rExperiencia;
    
    public List<Experiencia> getAll() {
        return rExperiencia.findAll();
    }
    
    public Optional<Experiencia> getById(int id){
        return rExperiencia.findById(id);
    }
    
    public Optional<Experiencia> getByNombreExp(String nombreExp){
        return rExperiencia.findByNombreExp(nombreExp);
    }
    
    public void save(Experiencia exp){
        rExperiencia.save(exp);
    }
    
    public void deleteById(int id){
        rExperiencia.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rExperiencia.existsById(id);
    }
    
    public boolean existsByNombreExp(String nombreExp){
        return rExperiencia.existsByNombreExp(nombreExp);
    }  
}
