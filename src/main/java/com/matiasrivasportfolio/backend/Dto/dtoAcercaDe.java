package com.matiasrivasportfolio.backend.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoAcercaDe {
    
    @NotBlank
    public String textoACD;
        

    public dtoAcercaDe() {
    }

    public dtoAcercaDe(String textoACD) {
        this.textoACD = textoACD;        
    }

}
