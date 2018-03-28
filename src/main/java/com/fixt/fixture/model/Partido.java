package com.fixt.fixture.model;

import javax.persistence.*;

/**
 * Created by kevinvarela on 06/03/18.
 */

@Entity
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    Equipo local;

    @OneToOne
    Equipo visitante;

    Integer golesLocal;

    Integer golesVisitante;

    public Partido(Equipo local, Equipo visitante) {
        //TODO VALIDAR QUE SEAN EQUIPOS VALIDOS
        this.local = local;
        this.visitante = visitante;
        this.golesLocal = -1;
        this.golesVisitante = -1;
    }

    public Boolean fueJugado(){
        return !(golesLocal == -1 || golesVisitante == -1 );
    }

    public Partido() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Equipo getLocal() {
        return local;
    }

    public void setLocal(Equipo local) {
        this.local = local;
    }

    public Equipo getVisitante() {
        return visitante;
    }

    public void setVisitante(Equipo visitante) {
        this.visitante = visitante;
    }

    public Integer getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(Integer golesLocal) {
        this.golesLocal = golesLocal;
    }

    public Integer getGolesVisitante() {
        return golesVisitante;
    }

    public void setGolesVisitante(Integer golesVisitante) {
        this.golesVisitante = golesVisitante;
    }
}
