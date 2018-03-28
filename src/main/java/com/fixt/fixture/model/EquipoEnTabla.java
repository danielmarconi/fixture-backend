package com.fixt.fixture.model;

import javax.persistence.*;

/**
 * Created by kevinvarela on 28/03/18.
 */

@Entity
public class EquipoEnTabla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Equipo equipo;

    private Integer partidosJugados;

    private Integer partidosGanados;

    private Integer partidosEmpatados;

    private Integer partidosPerdidos;

    private Integer diferenciaDeGoles;

    private Integer puntos;

    public EquipoEnTabla() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Integer getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(Integer partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public Integer getPartidosGanados() {
        return partidosGanados;
    }

    public void setPartidosGanados(Integer partidosGanados) {
        this.partidosGanados = partidosGanados;
    }

    public Integer getPartidosEmpatados() {
        return partidosEmpatados;
    }

    public void setPartidosEmpatados(Integer partidosEmpatados) {
        this.partidosEmpatados = partidosEmpatados;
    }

    public Integer getPartidosPerdidos() {
        return partidosPerdidos;
    }

    public void setPartidosPerdidos(Integer partidosPerdidos) {
        this.partidosPerdidos = partidosPerdidos;
    }

    public Integer getDiferenciaDeGoles() {
        return diferenciaDeGoles;
    }

    public void setDiferenciaDeGoles(Integer diferenciaDeGoles) {
        this.diferenciaDeGoles = diferenciaDeGoles;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }
}
