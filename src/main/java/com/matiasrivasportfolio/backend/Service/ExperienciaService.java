package com.matiasrivasportfolio.backend.Service;

import com.matiasrivasportfolio.backend.Model.Experiencia;
import com.matiasrivasportfolio.backend.Repository.IExperienciaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienciaService {
    
    @Autowired
    IExperienciaRepository iExperienciaRepository;
    
    public List<Experiencia> list(){
        return iExperienciaRepository.findAll();
    }
    
    public Optional<Experiencia> getOne(int id){
        return iExperienciaRepository.findById(id);
    }
    
    public Optional<Experiencia> getByNombreExp(String nombreExp){
        return iExperienciaRepository.findByNombreExp(nombreExp);
    }
    
    public void save(Experiencia experiencia){
        iExperienciaRepository.save(experiencia);
    }
    
    public void delete(int id){
        iExperienciaRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iExperienciaRepository.existsById(id);
    }
    
    public boolean existsByNombreExp(String nombreExp){
        return iExperienciaRepository.existsByNombreExp(nombreExp);
    }
}
