package com.matiasrivasportfolio.backend.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoSocial {
    
    @NotBlank
    private String urlSocial;
    
    @NotBlank
    private String imgSocial;
    
    @NotBlank
    private boolean showImg;

    public dtoSocial() {
    }

    public dtoSocial(String urlSocial, String imgSocial, boolean showImg) {
        this.urlSocial = urlSocial;
        this.imgSocial = imgSocial;
        this.showImg = showImg;
    }
    
    
}
