
package com.yoprogramo.portfolioBack.controller;

import com.yoprogramo.portfolioBack.model.Persona;
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
import com.yoprogramo.portfolioBack.service.SPersona;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("perso")
@CrossOrigin (origins="http://localhost:4200")
public class CPersona {
    
    @Autowired
    private SPersona persoServ;
    
    @GetMapping ("/all")
    @ResponseBody
    public List<Persona> all() {
        return persoServ.getAll();
    }
    
    @GetMapping("/detail/{id}")
    public Persona detail(@PathVariable int id) {
        return persoServ.getById(id);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/create")
    public void create(@RequestBody Persona pers) {
        persoServ.save(pers);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public Persona update(@PathVariable int id, @RequestParam("nombre") String nuevoNombre, @RequestParam("apellido") String nuevoApellido) {
        Persona perso = persoServ.getById(id);
        perso.setNombre(nuevoNombre);
        perso.setApellido(nuevoApellido);
        persoServ.save(perso);
        return perso;
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/delete/{id}")
    public void delete (@PathVariable int id){
        persoServ.deleteById(id);
    }
}
