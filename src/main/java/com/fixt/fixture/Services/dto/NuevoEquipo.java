package com.fixt.fixture.Services.dto;

/**
 * Created by kevinvarela on 25/04/18.
 */
public class NuevoEquipo {

    private String nombre;
    private String imagen;

    public NuevoEquipo() {
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
    public String toString() {
        return "NuevoEquipo{" +
                "nombre='" + nombre + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}
