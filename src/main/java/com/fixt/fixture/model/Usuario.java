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

    String nombre;
    String telefono;
    String psn_user;

    @OneToOne
    Equipo equipo;

    public Usuario(String nombre, String telefono, String psn_user, Equipo equipo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.psn_user = psn_user;
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

    public String getPsn_user() {
        return psn_user;
    }

    public void setPsn_user(String psn_user) {
        this.psn_user = psn_user;
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
