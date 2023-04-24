
package com.yoprogramo.portfolioBack.controller;

import com.yoprogramo.portfolioBack.dto.dtoRed;
import com.yoprogramo.portfolioBack.model.Red;
import com.yoprogramo.portfolioBack.security.controller.Mensaje;
import com.yoprogramo.portfolioBack.service.SRed;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("red")
@CrossOrigin(origins = "http://localhost:4200")
public class CRed {
    
    @Autowired
    SRed sRed;
    
    @GetMapping("/all")
    public ResponseEntity<List<Red>> all() {
        return new ResponseEntity(sRed.getAll(), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Red> detail(@PathVariable("id") int id) {
        if(!sRed.existsById(id)){
            return new ResponseEntity(new Mensaje("La red no existe"), HttpStatus.NOT_FOUND);
        }
        
        Red red = sRed.getById(id).get();
        return new ResponseEntity(red, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoRed dtoRed) {
        if(StringUtils.isBlank(dtoRed.getLink())){
            return new ResponseEntity(new Mensaje("El link es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sRed.existsByLink(dtoRed.getLink())){
            return new ResponseEntity(new Mensaje("El link ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Red red = new Red(dtoRed.getLink(), dtoRed.getClase());
        sRed.save(red);
        return new ResponseEntity(new Mensaje("Red agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoRed dtoRed){
        if(!sRed.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        if(sRed.existsByLink(dtoRed.getLink()) && sRed.getByLink(dtoRed.getLink()).get().getId() != id){
            return new ResponseEntity(new Mensaje("El link ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoRed.getLink())){
            return new ResponseEntity(new Mensaje("El link es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        Red red = sRed.getById(id).get();
        red.setLink(dtoRed.getLink());
        red.setClase(dtoRed.getClase());
        sRed.save(red);
        return new ResponseEntity(new Mensaje("Red actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sRed.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        
        sRed.deleteById(id);
        return new ResponseEntity(new Mensaje("Red eliminada"), HttpStatus.OK);
    }
}
