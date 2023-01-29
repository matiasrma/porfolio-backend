package com.matiasrivasportfolio.backend.Controller;

import com.matiasrivasportfolio.backend.Dto.dtoSocial;
import com.matiasrivasportfolio.backend.Model.Social;
import com.matiasrivasportfolio.backend.Security.Controller.Mensaje;
import com.matiasrivasportfolio.backend.Service.SocialService;
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
@RequestMapping("/social")
//@CrossOrigin("https://matiasrivas-portfolio.web.app/")
@CrossOrigin("http://localhost:4200/")
public class SocialController {
    
    @Autowired
    SocialService socialService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Social>> list(){
        List<Social> list = socialService.list();
        
        return new ResponseEntity(list, HttpStatus.OK);
    }    
    
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSocial dtosocial){
        
        Social social = new Social(    
                dtosocial.getUrlSocial(),
                dtosocial.getImgSocial(),
                dtosocial.isShowImg()
                );
        socialService.save(social);
        
        return new ResponseEntity(new Mensaje("Social agregado"), HttpStatus.OK);
    }
    
        
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
                
        socialService.delete(id);
        
        return new ResponseEntity(new Mensaje("Social eliminada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSocial dtosocial){
        if(!socialService.existsById(id))
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.BAD_REQUEST);
                        
        Social social = socialService.getOne(id).get();
        
        social.setUrlSocial(dtosocial.getUrlSocial());
        social.setImgSocial(dtosocial.getImgSocial());  
        social.setShowImg(dtosocial.isShowImg());
        
        socialService.save(social);
        
        return new ResponseEntity(new Mensaje("Social actualizada"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Social> getOne(@PathVariable("id") int id){
        if(!socialService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el Id"), HttpStatus.OK);
        }
        Social social = socialService.getOne(id).get();        
        return new ResponseEntity(social, HttpStatus.OK);
    }
    
}
