
package com.yoprogramo.portfolioBack.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoSkill {
    
    @NotBlank
    private String nombreSki;
    @NotBlank
    private int score;

    public dtoSkill() {
    }

    public dtoSkill(String nombreSki, int score) {
        this.nombreSki = nombreSki;
        this.score = score;
    }
}
