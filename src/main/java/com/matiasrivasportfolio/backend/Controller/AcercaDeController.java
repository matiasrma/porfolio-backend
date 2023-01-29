package com.matiasrivasportfolio.backend.Controller;

import com.matiasrivasportfolio.backend.Dto.dtoAcercaDe;
import com.matiasrivasportfolio.backend.Model.AcercaDe;
import com.matiasrivasportfolio.backend.Security.Controller.Mensaje;
import com.matiasrivasportfolio.backend.Service.AcercaDeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/acercade")
//@CrossOrigin("https://matiasrivas-portfolio.web.app/")
@CrossOrigin("http://localhost:4200/")
public class AcercaDeController {
    
    
    @Autowired
    AcercaDeService acercaDeService;
        
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoAcercaDe dtoacercaDe){
        
        AcercaDe acercaDe = new AcercaDe(dtoacercaDe.getTextoACD());
        
        acercaDeService.save(acercaDe);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<AcercaDe> getOne(@PathVariable("id") int id){
        if(!acercaDeService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el Id"), HttpStatus.OK);
        }
        
        AcercaDe acercaDe = acercaDeService.getOne(id).get();              
        return new ResponseEntity(acercaDe, HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoAcercaDe dtoacercaDe){
        if(!acercaDeService.existsById(id))
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.BAD_REQUEST);
        
        AcercaDe acercaDe = acercaDeService.getOne(id).get();        
        acercaDe.setTextoACD(dtoacercaDe.getTextoACD());
        
        
        acercaDeService.save(acercaDe);
        
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    }
}
