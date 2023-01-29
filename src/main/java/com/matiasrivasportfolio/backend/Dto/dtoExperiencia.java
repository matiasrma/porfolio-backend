package com.matiasrivasportfolio.backend.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoExperiencia {
    
    @NotBlank
    private String nombreExp;    
    @NotBlank
    private String descripcionExp;
    @NotBlank
    private String tiempoExp;
    @NotBlank
    private String imgExp;

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreExp, String descripcionExp, String tiempoExp, String imgExp) {
        this.nombreExp = nombreExp;
        this.descripcionExp = descripcionExp;
        this.tiempoExp = tiempoExp;
        this.imgExp = imgExp;
    }

        
    
}
