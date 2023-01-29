package com.matiasrivasportfolio.backend.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
public class Skill {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nombreSkill;
    private int percentageSkill;
    private String imgSkill;
    private boolean showImg;

    public Skill() {
    }

    public Skill(String nombreSkill, int percentageSkill, String imgSkill, boolean showImg) {
        this.nombreSkill = nombreSkill;
        this.percentageSkill = percentageSkill;
        this.imgSkill = imgSkill;
        this.showImg = showImg;
    }
    
}
