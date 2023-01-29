package com.matiasrivasportfolio.backend.Controller;

import com.matiasrivasportfolio.backend.Dto.dtoExperiencia;
import com.matiasrivasportfolio.backend.Model.Experiencia;
import com.matiasrivasportfolio.backend.Security.Controller.Mensaje;
import com.matiasrivasportfolio.backend.Service.ExperienciaService;
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
@RequestMapping("/experiencia")
//@CrossOrigin("https://matiasrivas-portfolio.web.app/")
@CrossOrigin("http://localhost:4200/")
public class ExperienciaController {
    
    @Autowired
    ExperienciaService experienciaService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = experienciaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }    
    
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoExp){
        if(StringUtils.isBlank(dtoExp.getNombreExp()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(experienciaService.existsByNombreExp(dtoExp.getNombreExp()))
            return new ResponseEntity(new Mensaje("Esa experiencia exite"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = new Experiencia(
                dtoExp.getNombreExp(), 
                dtoExp.getDescripcionExp(),
                dtoExp.getTiempoExp(),
                dtoExp.getImgExp()                
                );
        experienciaService.save(experiencia);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getOne(@PathVariable("id") int id){
        if(!experienciaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el Id"), HttpStatus.OK);
        }
        
        Experiencia experiencia = experienciaService.getOne(id).get();        
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperiencia dtoExp){
        if(!experienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.BAD_REQUEST);
        
        if(experienciaService.existsByNombreExp(dtoExp.getNombreExp()) && 
                experienciaService.getByNombreExp(dtoExp.getNombreExp()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa Experiencia ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoExp.getNombreExp()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = experienciaService.getOne(id).get();
        experiencia.setNombreExp(dtoExp.getNombreExp());
        experiencia.setDescripcionExp(dtoExp.getDescripcionExp());
        experiencia.setTiempoExp(dtoExp.getTiempoExp());
        experiencia.setImgExp(dtoExp.getImgExp());
        
        experienciaService.save(experiencia);
        
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!experienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.BAD_REQUEST);
        
        experienciaService.delete(id);
        
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }
}
