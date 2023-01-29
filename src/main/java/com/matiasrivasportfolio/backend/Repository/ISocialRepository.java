package com.matiasrivasportfolio.backend.Repository;

import com.matiasrivasportfolio.backend.Model.Social;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISocialRepository extends JpaRepository<Social, Integer>{
    
}
