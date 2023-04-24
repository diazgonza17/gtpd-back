
package com.yoprogramo.portfolioBack.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoExperiencia {
    
    @NotBlank
    private String nombreExp;
    @NotBlank
    private String descripcionExp;
    @NotBlank
    private int inicioExp;
    @NotBlank
    private int finExp;
    
    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreExp, String descripcionExp, int inicioExp, int finExp) {
        this.nombreExp = nombreExp;
        this.descripcionExp = descripcionExp;
        this.inicioExp = inicioExp;
        this.finExp = finExp;
    }
}
