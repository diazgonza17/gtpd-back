
package com.yoprogramo.portfolioBack.controller;

import com.yoprogramo.portfolioBack.dto.dtoExperiencia;
import com.yoprogramo.portfolioBack.model.Experiencia;
import com.yoprogramo.portfolioBack.security.controller.Mensaje;
import com.yoprogramo.portfolioBack.service.SExperiencia;
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
@RequestMapping("exp")
@CrossOrigin(origins = "https://portfolio-front-gonza.web.app")
public class CExperiencia {

    @Autowired
    SExperiencia sExperiencia;

    @GetMapping("/all")
    public ResponseEntity<List<Experiencia>> all() {
        return new ResponseEntity(sExperiencia.getAll(), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> detail(@PathVariable("id") int id){
        if(!sExperiencia.existsById(id)){
            return new ResponseEntity(new Mensaje("La experiencia no existe"), HttpStatus.NOT_FOUND);
        }
        
        Experiencia experiencia = sExperiencia.getById(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoExp) {
        if (StringUtils.isBlank(dtoExp.getNombreExp())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sExperiencia.existsByNombreExp(dtoExp.getNombreExp())) {
            return new ResponseEntity(new Mensaje("La experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Experiencia experiencia = new Experiencia(dtoExp.getNombreExp(), dtoExp.getDescripcionExp(), dtoExp.getInicioExp(), dtoExp.getFinExp());
        sExperiencia.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperiencia dtoExp) {
        if (!sExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        if (sExperiencia.existsByNombreExp(dtoExp.getNombreExp()) && sExperiencia.getByNombreExp(dtoExp.getNombreExp()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("La experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoExp.getNombreExp())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = sExperiencia.getById(id).get();
        experiencia.setNombreExp(dtoExp.getNombreExp());
        experiencia.setDescripcionExp(dtoExp.getDescripcionExp());
        experiencia.setInicioExp(dtoExp.getInicioExp());
        experiencia.setFinExp(dtoExp.getFinExp());
        sExperiencia.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        
        sExperiencia.deleteById(id);
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }
}
