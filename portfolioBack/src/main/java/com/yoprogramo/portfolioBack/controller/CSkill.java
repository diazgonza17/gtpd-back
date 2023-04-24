
package com.yoprogramo.portfolioBack.controller;

import com.yoprogramo.portfolioBack.dto.dtoSkill;
import com.yoprogramo.portfolioBack.model.Skill;
import com.yoprogramo.portfolioBack.security.controller.Mensaje;
import com.yoprogramo.portfolioBack.service.SSkill;
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
@RequestMapping("ski")
@CrossOrigin(origins = "http://localhost:4200")
public class CSkill {
    
    @Autowired
    SSkill sSkill;
    
    @GetMapping("/all")
    public ResponseEntity<List<Skill>> all() {
        return new ResponseEntity(sSkill.getAll(), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skill> detail(@PathVariable("id") int id) {
        if(!sSkill.existsById(id)){
            return new ResponseEntity(new Mensaje("La skill no existe"), HttpStatus.NOT_FOUND);
        }
        
        Skill skill = sSkill.getById(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkill dtoSki){
        if(StringUtils.isBlank(dtoSki.getNombreSki())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sSkill.existsByNombreSki(dtoSki.getNombreSki())){
            return new ResponseEntity(new Mensaje("La skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Skill skill = new Skill(dtoSki.getNombreSki(), dtoSki.getScore());
        sSkill.save(skill);
        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSkill dtoSki){
        if(!sSkill.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        if(sSkill.existsByNombreSki(dtoSki.getNombreSki()) && sSkill.getByNombre(dtoSki.getNombreSki()).get().getId() != id){
            return new ResponseEntity(new Mensaje("La educacion ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoSki.getNombreSki())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        Skill skill = sSkill.getById(id).get();
        skill.setNombreSki(dtoSki.getNombreSki());
        skill.setScore(dtoSki.getScore());
        sSkill.save(skill);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);
    } 
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sSkill.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        
        sSkill.deleteById(id);
        return new ResponseEntity(new Mensaje("Skill eliminada"), HttpStatus.OK);
    }    
}
