package com.matiasrivasportfolio.backend.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity
public class Proyecto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String descripcionProyecto;
    private String nombreProyecto;
    private String urlProyecto;

    public Proyecto() {
    }

    public Proyecto(String descripcionProyecto, String nombreProyecto, String urlProyecto) {
        this.descripcionProyecto = descripcionProyecto;
        this.nombreProyecto = nombreProyecto;
        this.urlProyecto = urlProyecto;
    }
    
    
}
