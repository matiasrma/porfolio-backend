package com.matiasrivasportfolio.backend.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoEducacion {
    
    @NotBlank
    private String nombreEdu;    
    @NotBlank
    private String descripcionEdu;   
    @NotBlank
    private String tiempoEdu;
    @NotBlank
    private String imgEdu;

    public dtoEducacion() {
    }

    public dtoEducacion(String nombreEdu, String descripcionEdu, String tiempoEdu, String imgEdu) {
        this.nombreEdu = nombreEdu;
        this.descripcionEdu = descripcionEdu;
        this.tiempoEdu = tiempoEdu;
        this.imgEdu = imgEdu;
    }

}
