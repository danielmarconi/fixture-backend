package com.fixt.fixture.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevinvarela on 13/03/18.
 */
@Entity
public class Torneo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String nombre;

    @OneToMany
    List<Fecha> fechas = new ArrayList<>();

    Integer fechaHabilitida;

    public Torneo(String nombre) {
        this.nombre = nombre;
        this.fechaHabilitida = 0;
    }

    public Torneo() {
    }

    public void agregarFechas(Fecha fechaNueva){
        //TODO VALIDAR QUE LA FECHA CONTENGA PARTIDOS
        fechas.add(fechaNueva);
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

    public List<Fecha> getFechas() {
        return fechas;
    }

    public void setFechas(List<Fecha> fechas) {
        this.fechas = fechas;
    }

    public Integer getFechaHabilitida() {
        return fechaHabilitida;
    }

    public void setFechaHabilitida(Integer fechaHabilitida) {
        this.fechaHabilitida = fechaHabilitida;
    }
}
