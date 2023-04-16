
package com.yoprogramo.portfolioBack.security.controller;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Mensaje {

    private String mensaje;
    
    //Constructores
    public Mensaje() {
    }
    
    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
