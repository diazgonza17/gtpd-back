
package com.yoprogramo.portfolioBack.controller;

import com.yoprogramo.portfolioBack.model.Persona;
import com.yoprogramo.portfolioBack.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin (origins="http://localhost:4200")
public class PersonaController {
    
    @Autowired
    private IPersonaService persoServ;
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/persona/new")
    public void agregarPersona(@RequestBody Persona pers) {
        persoServ.crearPersona(pers);
    }
    
    @GetMapping ("/persona/all")
    @ResponseBody
    public List<Persona> verPersonas() {
        return persoServ.verPersonas();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/persona/delete/{id}")
    public void borrarPersona (@PathVariable Long id){
        persoServ.borrarPersona(id);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/persona/edit/{id}")
    public Persona editPersona(@PathVariable Long id,
                               @RequestParam("nombre") String nuevoNombre,
                               @RequestParam("apellido") String nuevoApellido) {
        Persona perso = persoServ.buscarPersona(id);
        
        perso.setNombre(nuevoNombre);
        perso.setApellido(nuevoApellido);
    
        persoServ.crearPersona(perso);
        return perso;
    }
    
    @GetMapping("persona/perfil")
    public Persona buscarPersona() {
        return persoServ.buscarPersona(1L);
    }

}
