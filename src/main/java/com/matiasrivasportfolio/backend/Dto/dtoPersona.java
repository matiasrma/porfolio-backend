package com.matiasrivasportfolio.backend.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoPersona {
    
    @NotBlank
    private String nombre;        
    @NotBlank
    private String apellido;
    @NotBlank
    private String img;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String ubicacion;
    @NotBlank
    private String intereses;
    @NotBlank
    private String correo;     
    @NotBlank
    private String banner;

    public dtoPersona() {
    }

    public dtoPersona(String apellido, String img, String descripcion, String ubicacion, String intereses, String correo, String banner) {
        this.apellido = apellido;
        this.img = img;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.intereses = intereses;
        this.correo = correo;
        this.banner = banner;
    }

    
    
}
