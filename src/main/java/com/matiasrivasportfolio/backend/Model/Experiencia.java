package com.matiasrivasportfolio.backend.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Experiencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreExp;
    private String descripcionExp;
    private String tiempoExp;
    private String imgExp;    

    public Experiencia() {
    }

    public Experiencia(String nombreExp, String descripcionExp, String tiempoExp, String imgExp) {
        this.nombreExp = nombreExp;
        this.descripcionExp = descripcionExp;
        this.tiempoExp = tiempoExp;
        this.imgExp = imgExp;        
    }

    
    
}
