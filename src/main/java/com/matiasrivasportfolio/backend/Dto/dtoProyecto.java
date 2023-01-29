package com.matiasrivasportfolio.backend.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoProyecto {
    
    @NotBlank
    private String nombreProyecto;
    
    @NotBlank
    private String descripcionProyecto;
    
    @NotBlank
    private String urlProyecto;

    public dtoProyecto() {
    }

    public dtoProyecto(String nombreProyecto, String descripcionProyecto, String urlProyecto) {
        this.nombreProyecto = nombreProyecto;
        this.descripcionProyecto = descripcionProyecto;
        this.urlProyecto = urlProyecto;
    }
    
    
}
