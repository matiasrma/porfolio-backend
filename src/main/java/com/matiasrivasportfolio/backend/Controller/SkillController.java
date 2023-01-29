package com.matiasrivasportfolio.backend.Controller;

import com.matiasrivasportfolio.backend.Dto.dtoSkill;
import com.matiasrivasportfolio.backend.Model.Skill;
import com.matiasrivasportfolio.backend.Security.Controller.Mensaje;
import com.matiasrivasportfolio.backend.Service.SkillService;
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
@RequestMapping("/skill")
//@CrossOrigin("https://matiasrivas-portfolio.web.app/")
@CrossOrigin("http://localhost:4200/")
public class SkillController {
    
    @Autowired
    SkillService skillService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Skill>> list(){
        List<Skill> list = skillService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }    
    
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkill dtoskill){
        if(StringUtils.isBlank(dtoskill.getNombreSkill()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(skillService.existsByNombreSkill(dtoskill.getNombreSkill()))
            return new ResponseEntity(new Mensaje("Ese texto exite"), HttpStatus.BAD_REQUEST);
        
        Skill skill = new Skill(
                dtoskill.getNombreSkill(), 
                dtoskill.getPercentageSkill(),
                dtoskill.getImgSkill(),
                dtoskill.isShowImg()
                );
        skillService.save(skill);
        
        return new ResponseEntity(new Mensaje("Skill agregado"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skill> getOne(@PathVariable("id") int id){
        if(!skillService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el Id"), HttpStatus.OK);
        }
        Skill skill = skillService.getOne(id).get();        
        return new ResponseEntity(skill, HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSkill dtoskill){
        if(!skillService.existsById(id))
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.BAD_REQUEST);
        
        if(skillService.existsByNombreSkill(dtoskill.getNombreSkill()) && 
                skillService.getByNombreSkill(dtoskill.getNombreSkill()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa Skill ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoskill.getNombreSkill()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Skill skill = skillService.getOne(id).get();
        
        skill.setNombreSkill(dtoskill.getNombreSkill());
        skill.setPercentageSkill(dtoskill.getPercentageSkill());
        skill.setImgSkill(dtoskill.getImgSkill());
        skill.setShowImg(dtoskill.isShowImg());
        
        skillService.save(skill);
        
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!skillService.existsById(id))
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.BAD_REQUEST);
        
        skillService.delete(id);
        
        return new ResponseEntity(new Mensaje("Skill eliminada"), HttpStatus.OK);
    }
    
}
