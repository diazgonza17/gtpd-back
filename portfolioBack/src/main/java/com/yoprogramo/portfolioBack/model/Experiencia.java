
package com.yoprogramo.portfolioBack.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Experiencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreExp;
    private String descripcionExp;
    private int inicioExp;
    private int finExp;
    
    public Experiencia() {
    }

    public Experiencia(String nombreExp, String descripcionExp, int inicioExp, int finExp) {
        this.nombreExp = nombreExp;
        this.descripcionExp = descripcionExp;
        this.inicioExp = inicioExp;
        this.finExp = finExp;
    }
}
