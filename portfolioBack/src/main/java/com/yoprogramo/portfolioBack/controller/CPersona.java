
package com.yoprogramo.portfolioBack.controller;

import com.yoprogramo.portfolioBack.dto.dtoPersona;
import com.yoprogramo.portfolioBack.model.Persona;
import com.yoprogramo.portfolioBack.security.controller.Mensaje;
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
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("perso")
@CrossOrigin(origins="http://localhost:4200")
public class CPersona {
    
    @Autowired
    SPersona sPersona;
    
    @GetMapping ("/all")
    @ResponseBody
    public ResponseEntity<List<Persona>> all() {
        return new ResponseEntity(sPersona.getAll(), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> detail(@PathVariable("id") int id) {
        if(!sPersona.existsById(id)){
            return new ResponseEntity(new Mensaje("La persona no existe"), HttpStatus.NOT_FOUND);
        }
        
        Persona persona = sPersona.getById(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    
    @PostMapping ("/create")
    public ResponseEntity<?> create(@RequestBody dtoPersona dtoPerso) {
        if(StringUtils.isBlank(dtoPerso.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sPersona.existsByNombre(dtoPerso.getNombre())){
            return new ResponseEntity(new Mensaje("La persona ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Persona persona = new Persona(dtoPerso.getNombre(), dtoPerso.getApellido());
        sPersona.save(persona);
        return new ResponseEntity(new Mensaje("Persona agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtoPerso) {
        if(!sPersona.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        if(sPersona.existsByNombre(dtoPerso.getNombre()) && sPersona.getByNombre(dtoPerso.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("La persona ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoPerso.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        Persona persona = sPersona.getById(id).get();
        persona.setNombre(dtoPerso.getNombre());
        persona.setApellido(dtoPerso.getApellido());
        sPersona.save(persona);
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sPersona.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        
        sPersona.deleteById(id);
        return new ResponseEntity(new Mensaje("Persona eliminada"), HttpStatus.OK);
    }
}
