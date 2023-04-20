
package com.yoprogramo.portfolioBack.security.service;

import com.yoprogramo.portfolioBack.security.entity.Usuario;
import javax.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yoprogramo.portfolioBack.security.repository.IRUsuario;

@Service
@Transactional
public class SUsuario {
    
    @Autowired
    IRUsuario rUsuarioRepository;
    
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario) {
        return rUsuarioRepository.findByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByNombreUsuario(String nombreUsuario){
        return rUsuarioRepository.existsByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByEmail(String email){
        return rUsuarioRepository.existsByEmail(email);
    }
    
    public void save(Usuario usuario){
        rUsuarioRepository.save(usuario);
    }
}
