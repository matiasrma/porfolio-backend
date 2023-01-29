package com.matiasrivasportfolio.backend.Service;

import com.matiasrivasportfolio.backend.Model.Social;
import com.matiasrivasportfolio.backend.Repository.ISocialRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class SocialService {
    
    @Autowired
    ISocialRepository iSocialRepository;
    
    public List<Social> list(){
        return iSocialRepository.findAll();
    }
    
            
    public void save(Social social){
        iSocialRepository.save(social);
    }
    
    public void delete(int id){
        iSocialRepository.deleteById(id);
    }
    
    public Optional<Social> getOne(int id){
        return iSocialRepository.findById(id);
    }
    
    public boolean existsById(int id){
        return iSocialRepository.existsById(id);
    }
    
}
