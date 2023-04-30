
package com.yoprogramo.portfolioBack.controller;

import com.yoprogramo.portfolioBack.dto.dtoProyecto;
import com.yoprogramo.portfolioBack.model.Proyecto;
import com.yoprogramo.portfolioBack.security.controller.Mensaje;
import com.yoprogramo.portfolioBack.service.SProyecto;
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
@RequestMapping("pro")
@CrossOrigin(origins = "https://portfolio-front-gonza.web.app")
public class CProyecto {
    
    @Autowired
    SProyecto sProyecto;
    
    @GetMapping("/all")
    public ResponseEntity<List<Proyecto>> all() {
        return new ResponseEntity(sProyecto.getAll(), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> detail(@PathVariable("id") int id) {
        if(!sProyecto.existsById(id)){
            return new ResponseEntity(new Mensaje("El proyecto no existe"), HttpStatus.NOT_FOUND);
        }
        
        Proyecto proyecto = sProyecto.getById(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyecto dtoPro){
        if(StringUtils.isBlank(dtoPro.getNombrePro())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sProyecto.existsByNombrePro(dtoPro.getNombrePro())){
            return new ResponseEntity(new Mensaje("El proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Proyecto proyecto = new Proyecto(dtoPro.getNombrePro(), dtoPro.getDescripcionPro(), dtoPro.getLink());
        sProyecto.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto agregado"), HttpStatus.OK);
    }  
 
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyecto dtoPro){
        if(!sProyecto.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        if(sProyecto.existsByNombrePro(dtoPro.getNombrePro()) && sProyecto.getByNombre(dtoPro.getNombrePro()).get().getId() != id){
            return new ResponseEntity(new Mensaje("El proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoPro.getNombrePro())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        Proyecto proyecto = sProyecto.getById(id).get();
        proyecto.setNombrePro(dtoPro.getNombrePro());
        proyecto.setDescripcionPro(dtoPro.getDescripcionPro());
        proyecto.setLink(dtoPro.getLink());
        sProyecto.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sProyecto.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        
        sProyecto.deleteById(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }    
}
