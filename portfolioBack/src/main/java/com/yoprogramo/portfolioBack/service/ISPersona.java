
package com.yoprogramo.portfolioBack.service;

import com.yoprogramo.portfolioBack.model.Persona;
import java.util.List;

public interface ISPersona {
    
    public List<Persona> verPersonas();
    public void crearPersona(Persona per);
    public void borrarPersona(Long id);
    public Persona buscarPersona(Long id);
}
