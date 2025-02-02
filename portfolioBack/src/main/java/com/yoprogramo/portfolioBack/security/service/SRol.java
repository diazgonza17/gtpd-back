
package com.yoprogramo.portfolioBack.security.service;

import com.yoprogramo.portfolioBack.security.entity.Rol;
import com.yoprogramo.portfolioBack.security.enums.RolNombre;
import javax.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yoprogramo.portfolioBack.security.repository.IRRol;

@Service
@Transactional
public class SRol {
    
    @Autowired
    IRRol rRol;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rRol.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol) {
        rRol.save(rol);
    }
}
