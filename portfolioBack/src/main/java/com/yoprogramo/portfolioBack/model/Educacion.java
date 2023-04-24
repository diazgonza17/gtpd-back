
package com.yoprogramo.portfolioBack.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Educacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreEdu;
    private String descripcionEdu;
    private int inicioEdu;
    private int finEdu;

    public Educacion() {
    }

    public Educacion(String nombreEdu, String descripcionEdu, int inicioEdu, int finEdu) {
        this.nombreEdu = nombreEdu;
        this.descripcionEdu = descripcionEdu;
        this.inicioEdu = inicioEdu;
        this.finEdu = finEdu;
    }
}
