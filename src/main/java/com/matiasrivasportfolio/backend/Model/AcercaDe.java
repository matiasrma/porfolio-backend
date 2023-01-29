package com.matiasrivasportfolio.backend.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class AcercaDe {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Size(min = 1, max = 1000, message = "no cumple con la longitud max 1000")
    private String textoACD;
    

    public AcercaDe() {
    }

    public AcercaDe(String textoACD) {
        this.textoACD = textoACD;        
    }
}

    
