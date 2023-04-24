
package com.yoprogramo.portfolioBack.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Skill {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreSki;
    private int score;

    public Skill() {
    }

    public Skill(String nombreSki, int score) {
        this.nombreSki = nombreSki;
        this.score = score;
    }
}
