
package com.yoprogramo.portfolioBack.service;

import com.yoprogramo.portfolioBack.model.Red;
import com.yoprogramo.portfolioBack.repository.IRRed;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SRed {
    
    @Autowired
    IRRed rRed;
    
    public List<Red> getAll(){
        return rRed.findAll();
    }
    
    public Optional<Red> getById(int id){
        return rRed.findById(id);
    }
    
    public Optional<Red> getByLink(String link){
        return rRed.findByLink(link);
    }
    
    public void save(Red red){
        rRed.save(red);
    }
    
    public void deleteById(int id){
        rRed.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rRed.existsById(id);
    }
    
    public boolean existsByLink(String link){
        return rRed.existsByLink(link);
    }
}
