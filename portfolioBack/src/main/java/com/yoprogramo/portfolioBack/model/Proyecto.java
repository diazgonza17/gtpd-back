
package com.yoprogramo.portfolioBack.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Proyecto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombrePro;
    private String descripcionPro;
    private String link;

    public Proyecto() {
    }

    public Proyecto(String nombrePro, String descripcionPro, String link) {
        this.nombrePro = nombrePro;
        this.descripcionPro = descripcionPro;
        this.link = link;
    }
}
