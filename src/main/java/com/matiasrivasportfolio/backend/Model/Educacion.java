package com.matiasrivasportfolio.backend.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Educacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreEdu;
    private String descripcionEdu;
    private String tiempoEdu;
    private String imgEdu;

    public Educacion() {
    }

    public Educacion(String nombreEdu, String descripcionEdu, String tiempoEdu, String imgEdu) {
        this.nombreEdu = nombreEdu;
        this.descripcionEdu = descripcionEdu;
        this.tiempoEdu = tiempoEdu;
        this.imgEdu = imgEdu;
    }
    
}
