package com.matiasrivasportfolio.backend.Service;

import com.matiasrivasportfolio.backend.Model.Proyecto;
import com.matiasrivasportfolio.backend.Repository.IProyectoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProyectoService {
    
    @Autowired
    IProyectoRepository iProyectoRepository;
    
    public List<Proyecto> list(){
        return iProyectoRepository.findAll();
    }
    
    public Optional<Proyecto> getOne(int id){
        return iProyectoRepository.findById(id);
    }
    
    public Optional<Proyecto> getByNombreProyecto(String nombreProyecto){
        return iProyectoRepository.findByNombreProyecto(nombreProyecto);
    }
    
    public void save(Proyecto proyecto){
        iProyectoRepository.save(proyecto);
    }
    
    public void delete(int id){
        iProyectoRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iProyectoRepository.existsById(id);
    }
    
    public boolean existsByNombreProyecto(String nombreProyecto){
        return iProyectoRepository.existsByNombreProyecto(nombreProyecto);
    }
}
