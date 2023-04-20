
package com.yoprogramo.portfolioBack.service;

import com.yoprogramo.portfolioBack.model.Educacion;
import com.yoprogramo.portfolioBack.repository.IREducacion;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SEducacion {
    
    @Autowired
    IREducacion rEducacion;
    
    public List<Educacion> getAll(){
        return rEducacion.findAll();
    }
    
    public Optional<Educacion> getById(int id){
        return rEducacion.findById(id);
    }
    
    public Optional<Educacion> getByNombre(String nombreEdu){
        return rEducacion.findByNombreEdu(nombreEdu);
    }
    
    public void save(Educacion edu){
        rEducacion.save(edu);
    }
    
    public void deleteById(int id){
        rEducacion.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rEducacion.existsById(id);
    }
    
    public boolean existsByNombreEdu(String nombreEdu){
        return rEducacion.existsByNombreEdu(nombreEdu);
    }
}
