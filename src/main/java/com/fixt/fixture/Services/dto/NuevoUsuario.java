package com.fixt.fixture.Services.dto;

/**
 * Created by GonzaloEsperidioni.
 */
public class NuevoUsuario {

    private String nombre;
    private String telefono;
    private String psn_user;
    private Long   idEquipo;

    public NuevoUsuario() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Long getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Long idEquipo) {
        this.idEquipo = idEquipo;
    }
}
