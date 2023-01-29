package com.matiasrivasportfolio.backend.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoSkill {
    
    @NotBlank
    private String nombreSkill;
    
    @NotBlank
    private int percentageSkill;
    
    @NotBlank
    private String imgSkill;
    
    @NotBlank
    private boolean showImg;
    
    public dtoSkill() {
    }

    public dtoSkill(String nombreSkill, int percentageSkill, String imgSkill, boolean showImg) {
        this.nombreSkill = nombreSkill;
        this.percentageSkill = percentageSkill;
        this.imgSkill = imgSkill;    
        this.showImg = showImg;
    }
    
    
}
