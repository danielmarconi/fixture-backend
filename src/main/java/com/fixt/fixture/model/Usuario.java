package com.fixt.fixture.model;

import javax.persistence.*;

/**
 * Created by kevinvarela on 06/03/18.
 */
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String telefono;
    private String psnUser;

    @OneToOne
    Equipo equipo;

    public Usuario(String nombre, String telefono, String psnUser, Equipo equipo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.psnUser = psnUser;
        this.equipo = equipo;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Usuario() {

    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPsnUser() {
        return psnUser;
    }

    public void setPsnUser(String psnUser) {
        this.psnUser = psnUser;
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

}
