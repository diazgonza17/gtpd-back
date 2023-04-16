
package com.yoprogramo.portfolioBack.security.service;

import com.yoprogramo.portfolioBack.security.entity.Rol;
import com.yoprogramo.portfolioBack.security.enums.RolNombre;
import com.yoprogramo.portfolioBack.security.repository.IRolRepository;
import javax.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    @Autowired
    IRolRepository irolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return irolRepository.findByRolNombre(rolNombre);
    };
    
    public void save(Rol rol) {
        irolRepository.save(rol);
    }
}
