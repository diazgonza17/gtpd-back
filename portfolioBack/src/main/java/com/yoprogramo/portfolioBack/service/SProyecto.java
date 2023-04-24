
package com.yoprogramo.portfolioBack.service;

import com.yoprogramo.portfolioBack.model.Proyecto;
import com.yoprogramo.portfolioBack.repository.IRProyecto;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SProyecto {
    
    @Autowired
    IRProyecto rProyecto;
    
    public List<Proyecto> getAll(){
        return rProyecto.findAll();
    }
    
    public Optional<Proyecto> getById(int id){
        return rProyecto.findById(id);
    }
    
    public Optional<Proyecto> getByNombre(String nombrePro){
        return rProyecto.findByNombrePro(nombrePro);
    }
    
    public void save(Proyecto pro){
        rProyecto.save(pro);
    }
    
    public void deleteById(int id){
        rProyecto.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rProyecto.existsById(id);
    }
    
    public boolean existsByNombrePro(String nombrePro){
        return rProyecto.existsByNombrePro(nombrePro);
    }    
}
