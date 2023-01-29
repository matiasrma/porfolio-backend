package com.matiasrivasportfolio.backend.Service;

import com.matiasrivasportfolio.backend.Model.AcercaDe;
import com.matiasrivasportfolio.backend.Repository.IAcercaDeRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AcercaDeService {
    
    @Autowired
    IAcercaDeRepository iAcercaDeRepository;
    
     public List<AcercaDe> list(){
        return iAcercaDeRepository.findAll();
    }
    
    
    public Optional<AcercaDe> getOne(int id){
        return iAcercaDeRepository.findById(id);
    }
    
    public void save(AcercaDe acercaDe){
        iAcercaDeRepository.save(acercaDe);
    }
    
    public boolean existsById(int id){
        return iAcercaDeRepository.existsById(id);
    }
            
}
