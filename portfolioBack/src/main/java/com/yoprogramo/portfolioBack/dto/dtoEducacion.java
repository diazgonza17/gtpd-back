
package com.yoprogramo.portfolioBack.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoEducacion {
    
    @NotBlank
    private String nombreEdu;
    @NotBlank
    private String descripcionEdu;
    @NotBlank
    private int inicioEdu;
    @NotBlank
    private int finEdu;

    public dtoEducacion() {
    }

    public dtoEducacion(String nombreEdu, String descripcionEdu, int inicioEdu, int finEdu) {
        this.nombreEdu = nombreEdu;
        this.descripcionEdu = descripcionEdu;
        this.inicioEdu = inicioEdu;
        this.finEdu = finEdu;
    }
}
