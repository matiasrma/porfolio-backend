package com.matiasrivasportfolio.backend.Service;

import com.matiasrivasportfolio.backend.Model.Skill;
import com.matiasrivasportfolio.backend.Repository.ISkillRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class SkillService {
    
    @Autowired
    ISkillRepository iSkillRepository;
    
    public List<Skill> list(){
        return iSkillRepository.findAll();
    }
    
    public Optional<Skill> getOne(int id){
        return iSkillRepository.findById(id);
    }
    
    public Optional<Skill> getByNombreSkill(String nombreSkill){
        return iSkillRepository.findByNombreSkill(nombreSkill);
    }
    
    public void save(Skill skill){
        iSkillRepository.save(skill);
    }
    
    public void delete(int id){
        iSkillRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iSkillRepository.existsById(id);
    }
    
    public boolean existsByNombreSkill(String nombreSkill){
        return iSkillRepository.existsByNombreSkill(nombreSkill);
    }
}
