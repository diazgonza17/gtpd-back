
package com.yoprogramo.portfolioBack.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoProyecto {
    
    @NotBlank
    private String nombrePro;
    @NotBlank
    private String descripcionPro;
    @NotBlank
    private String link;

    public dtoProyecto() {
    }

    public dtoProyecto(String nombrePro, String descripcionPro, String link) {
        this.nombrePro = nombrePro;
        this.descripcionPro = descripcionPro;
        this.link = link;
    }
}
