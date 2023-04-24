
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
    @NotBlank
    private String titulo;    
    @NotBlank
    private String ubicacion;

    public dtoPersona() {
    }

    public dtoPersona(String nombre, String apellido, String titulo, String ubicacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.ubicacion = ubicacion;
    }
}
