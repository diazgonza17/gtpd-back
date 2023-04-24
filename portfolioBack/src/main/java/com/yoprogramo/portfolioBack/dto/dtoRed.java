
package com.yoprogramo.portfolioBack.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoRed {
    
    @NotBlank
    private String link;
    @NotBlank
    private String clase;

    public dtoRed() {
    }

    public dtoRed(String link, String clase) {
        this.link = link;
        this.clase = clase;
    }
}
