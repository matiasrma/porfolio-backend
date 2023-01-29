package com.matiasrivasportfolio.backend.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Social {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String urlSocial;
    private String imgSocial;
    private boolean showImg;
    
    public Social() {
    }

    public Social(String urlSocial, String imgSocial, boolean showImg) {
        this.urlSocial = urlSocial;
        this.imgSocial = imgSocial;
        this.showImg = showImg;
    }   
    
    
}
