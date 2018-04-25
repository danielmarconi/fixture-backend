package com.fixt.fixture.Services.dto;

/**
 * Created by kevinvarela on 24/04/18.
 */
public class ResultadoPartido {

    private Long idPartido;
    private Integer golesLocal;
    private Integer golesVisitante;

    public ResultadoPartido() {
    }

    public Long getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(Long idPartido) {
        this.idPartido = idPartido;
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

    @Override
    public String toString() {
        return "ResultadoPartido{" +
                "idPartido=" + idPartido +
                ", golesLocal=" + golesLocal +
                ", golesVisitante=" + golesVisitante +
                '}';
    }
}
