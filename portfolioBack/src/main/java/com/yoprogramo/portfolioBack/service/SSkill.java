
package com.yoprogramo.portfolioBack.service;

import com.yoprogramo.portfolioBack.model.Skill;
import com.yoprogramo.portfolioBack.repository.IRSkill;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SSkill {
    
    @Autowired
    IRSkill rSkill;
    
    public List<Skill> getAll(){
        return rSkill.findAll();
    }
    
    public Optional<Skill> getById(int id){
        return rSkill.findById(id);
    }
    
    public Optional<Skill> getByNombre(String nombreSki){
        return rSkill.findByNombreSki(nombreSki);
    }
    
    public void save(Skill ski){
        rSkill.save(ski);
    }
    
    public void deleteById(int id){
        rSkill.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rSkill.existsById(id);
    }
    
    public boolean existsByNombreSki(String nombreSki){
        return rSkill.existsByNombreSki(nombreSki);
    }
}
