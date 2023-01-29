package com.matiasrivasportfolio.backend.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud max 50")
    private String nombre;
    
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud max 50")
    private String apellido;
        
    private String img;
    
    @Size(min = 1, max = 50, message = "no cumple con la longitud max 50")
    private String descripcion;
    
    @Size(min = 1, max = 50, message = "no cumple con la longitud max 50")
    private String ubicacion;
    
    @Size(min = 1, max = 50, message = "no cumple con la longitud max 50")
    private String intereses;
    
    @Size(min = 1, max = 80, message = "no cumple con la longitud max 50")
    private String correo;   
    
    private String banner;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String img, String descripcion, String ubicacion, String intereses, String correo, String banner) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.intereses = intereses;
        this.correo = correo;
        this.banner = banner;
    }

        
}
