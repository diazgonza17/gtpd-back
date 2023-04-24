
package com.yoprogramo.portfolioBack.controller;

import com.yoprogramo.portfolioBack.dto.dtoEducacion;
import com.yoprogramo.portfolioBack.model.Educacion;
import com.yoprogramo.portfolioBack.security.controller.Mensaje;
import com.yoprogramo.portfolioBack.service.SEducacion;
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
@RequestMapping("edu")
@CrossOrigin(origins = "http://localhost:4200")
public class CEducacion {
    
    @Autowired
    SEducacion sEducacion;
    
    @GetMapping("/all")
    public ResponseEntity<List<Educacion>> all() {
        return new ResponseEntity(sEducacion.getAll(), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> detail(@PathVariable("id") int id) {
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("La educacion no existe"), HttpStatus.NOT_FOUND);
        }
        
        Educacion educacion = sEducacion.getById(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoEdu){
        if(StringUtils.isBlank(dtoEdu.getNombreEdu())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sEducacion.existsByNombreEdu(dtoEdu.getNombreEdu())){
            return new ResponseEntity(new Mensaje("La educacion ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = new Educacion(dtoEdu.getNombreEdu(), dtoEdu.getDescripcionEdu(), dtoEdu.getInicioEdu(), dtoEdu.getFinEdu());
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoEdu){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        if(sEducacion.existsByNombreEdu(dtoEdu.getNombreEdu()) && sEducacion.getByNombre(dtoEdu.getNombreEdu()).get().getId() != id){
            return new ResponseEntity(new Mensaje("La educacion ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoEdu.getNombreEdu())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = sEducacion.getById(id).get();
        educacion.setNombreEdu(dtoEdu.getNombreEdu());
        educacion.setDescripcionEdu(dtoEdu.getDescripcionEdu());
        educacion.setInicioEdu(dtoEdu.getInicioEdu());
        educacion.setFinEdu(dtoEdu.getFinEdu());
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        
        sEducacion.deleteById(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }
}
