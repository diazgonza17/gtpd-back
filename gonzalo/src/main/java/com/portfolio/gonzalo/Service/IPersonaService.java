
package com.portfolio.gonzalo.Service;

import com.portfolio.gonzalo.Model.Persona;
import java.util.List;

public interface IPersonaService {
    
    public List<Persona> verPersonas();
    public void crearPersona(Persona per);
    public void borrarPersona(Long id);
    public Persona buscarPersona(Long id);
}
