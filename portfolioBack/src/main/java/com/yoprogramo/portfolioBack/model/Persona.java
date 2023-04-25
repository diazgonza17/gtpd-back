
package com.yoprogramo.portfolioBack.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Size(min = 1, max = 50, message = "Length not allowed")
    private String nombre;
    @NotNull
    @Size(min = 1, max = 50, message = "Length not allowed")
    private String apellido;
    private String titulo;
    private String ubicacion;
    @Column(length = 1000)
    private String about;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String titulo, String ubicacion, String about) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.ubicacion = ubicacion;
        this.about = about;
    }
}
