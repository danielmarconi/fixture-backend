package com.fixt.fixture.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by kevinvarela on 06/03/18.
 */
@Entity
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String nombre;

    String imagen;

    public Equipo(String nombre, String imagen) {
        if(nombre.isEmpty() || nombre == null){
            throw new RuntimeException("El nombre del equipo no debe estar vacio.");
        }
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public Equipo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipo equipo = (Equipo) o;
        return Objects.equals(nombre, equipo.nombre);
    }

    @Override
    public int hashCode() {

        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}
