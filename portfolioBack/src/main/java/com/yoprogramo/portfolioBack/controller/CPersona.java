
package com.yoprogramo.portfolioBack.controller;

import com.yoprogramo.portfolioBack.dto.dtoPersona;
import com.yoprogramo.portfolioBack.model.Persona;
import com.yoprogramo.portfolioBack.security.controller.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.yoprogramo.portfolioBack.service.SPersona;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("perso")
@CrossOrigin(origins="https://portfolio-front-gonza.web.app")
public class CPersona {
    
    @Autowired
    SPersona sPersona;

    @GetMapping("/detail")
    public ResponseEntity<Persona> detail() {
        if(!sPersona.existsById(1)){
            return new ResponseEntity(new Mensaje("La persona no existe"), HttpStatus.NOT_FOUND);
        }
        
        Persona persona = sPersona.getById(1).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody dtoPersona dtoPerso) {
        if(!sPersona.existsById(1)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        if(StringUtils.isBlank(dtoPerso.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        Persona persona = sPersona.getById(1).get();
        persona.setNombre(dtoPerso.getNombre());
        persona.setApellido(dtoPerso.getApellido());
        persona.setTitulo(dtoPerso.getTitulo());
        persona.setUbicacion(dtoPerso.getUbicacion());
        persona.setAbout(dtoPerso.getAbout());
        persona.setEmail(dtoPerso.getEmail());
        sPersona.save(persona);
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
    }
}
