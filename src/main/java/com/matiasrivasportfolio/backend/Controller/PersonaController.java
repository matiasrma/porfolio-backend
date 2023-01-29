package com.matiasrivasportfolio.backend.Controller;

import com.matiasrivasportfolio.backend.Dto.dtoPersona;
import com.matiasrivasportfolio.backend.Model.Persona;
import com.matiasrivasportfolio.backend.Security.Controller.Mensaje;
import com.matiasrivasportfolio.backend.Service.ImpPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/personas")
//@CrossOrigin("https://matiasrivas-portfolio.web.app/")
@CrossOrigin("http://localhost:4200/")
public class PersonaController {
    
    @Autowired
    ImpPersonaService impPersonaService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = impPersonaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }    
    
    /*
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoPersona dtoPersona){
        if(StringUtils.isBlank(dtoPersona.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(impPersonaService.existsByNombre(dtoPersona.getNombre()))
            return new ResponseEntity(new Mensaje("Esa Persona exite"), HttpStatus.BAD_REQUEST);
        
        Persona persona = new Persona(
                dtoPersona.getNombre(), 
                dtoPersona.getApellido(),
                dtoPersona.getImg(),
                dtoPersona.getDescripcion(),                 
                dtoPersona.getProvincia(),
                dtoPersona.getPais(),
                dtoPersona.getCorreo());
        impPersonaService.save(persona);
        
        return new ResponseEntity(new Mensaje("Persona agregada"), HttpStatus.OK);
    }
    */
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getOne(@PathVariable("id") int id){
        if(!impPersonaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el Id"), HttpStatus.OK);
        }
        
        Persona persona = impPersonaService.getOne(id).get();        
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtopersona){
        if(!impPersonaService.existsById(id))
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.BAD_REQUEST);
        
        if(impPersonaService.existsByNombre(dtopersona.getNombre()) && 
                impPersonaService.getByNombre(dtopersona.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa Persona ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtopersona.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Persona persona = impPersonaService.getOne(id).get();
        persona.setNombre(dtopersona.getNombre());
        persona.setApellido(dtopersona.getApellido());
        persona.setImg(dtopersona.getImg());
        persona.setDescripcion(dtopersona.getDescripcion());
        persona.setUbicacion(dtopersona.getUbicacion());
        persona.setIntereses(dtopersona.getIntereses());
        persona.setCorreo(dtopersona.getCorreo());
        persona.setBanner(dtopersona.getBanner());
                
        impPersonaService.save(persona);
        
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
    }
    /*
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!impPersonaService.existsById(id))
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.BAD_REQUEST);
        
        impPersonaService.delete(id);
        
        return new ResponseEntity(new Mensaje("Persona eliminada"), HttpStatus.OK);
    }
    */
}
