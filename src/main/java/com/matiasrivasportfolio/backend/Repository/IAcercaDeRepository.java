package com.matiasrivasportfolio.backend.Repository;

import com.matiasrivasportfolio.backend.Model.AcercaDe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAcercaDeRepository extends JpaRepository<AcercaDe, Integer>{
    
    
}
