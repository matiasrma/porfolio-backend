package com.matiasrivasportfolio.backend.Controller;

import com.matiasrivasportfolio.backend.Dto.dtoEducacion;
import com.matiasrivasportfolio.backend.Model.Educacion;
import com.matiasrivasportfolio.backend.Security.Controller.Mensaje;
import com.matiasrivasportfolio.backend.Service.EducacionService;
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
@RequestMapping("/educacion")
//@CrossOrigin("https://matiasrivas-portfolio.web.app/")
@CrossOrigin("http://localhost:4200/")
public class EducacionController {
    
    @Autowired
    EducacionService educacionService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = educacionService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }    
    
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoEdu){
        if(StringUtils.isBlank(dtoEdu.getNombreEdu()))
            return new ResponseEntity(new Mensaje("El texto es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(educacionService.existsByNombreEdu(dtoEdu.getNombreEdu()))
            return new ResponseEntity(new Mensaje("Ese texto exite"), HttpStatus.BAD_REQUEST);
        
        Educacion educacion = new Educacion(
                dtoEdu.getNombreEdu(), 
                dtoEdu.getDescripcionEdu(),
                dtoEdu.getTiempoEdu(),
                dtoEdu.getImgEdu()
                );
        educacionService.save(educacion);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getOne(@PathVariable("id") int id){
        if(!educacionService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el Id"), HttpStatus.OK);
        }
        Educacion educacion = educacionService.getOne(id).get();        
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoEdu){
        if(!educacionService.existsById(id))
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.BAD_REQUEST);
        
        if(educacionService.existsByNombreEdu(dtoEdu.getNombreEdu()) && 
                educacionService.getByNombreEdu(dtoEdu.getNombreEdu()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa Experiencia ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoEdu.getNombreEdu()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Educacion educacion = educacionService.getOne(id).get();
        
        educacion.setNombreEdu(dtoEdu.getNombreEdu());
        educacion.setDescripcionEdu(dtoEdu.getDescripcionEdu());
        educacion.setTiempoEdu(dtoEdu.getTiempoEdu());
        educacion.setImgEdu(dtoEdu.getImgEdu());
        
        educacionService.save(educacion);
        
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!educacionService.existsById(id))
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.BAD_REQUEST);
        
        educacionService.delete(id);
        
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }
}
