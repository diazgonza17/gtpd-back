
package com.yoprogramo.portfolioBack.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoPersona {
    
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;

    public dtoPersona() {
    }

    public dtoPersona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
}
