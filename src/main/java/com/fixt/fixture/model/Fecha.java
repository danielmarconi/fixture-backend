package com.fixt.fixture.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevinvarela on 13/03/18.
 */
@Entity
public class Fecha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    Integer numeroDeFecha;

    @OneToMany
    List<Partido> partidos = new ArrayList<>();

    public Fecha(Integer numeroDeFecha) {
        //TODO VALIDAR QUE SEA UN NUMERO DE FECHA VALIDO
        this.numeroDeFecha = numeroDeFecha;
    }

    public Fecha() {
    }

    public void agregarPartido(Partido partidoNuevo){
        //TODO VALIDAR QUE SEA UN PARTIDO VALIDO
        partidos.add(partidoNuevo);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumeroDeFecha() {
        return numeroDeFecha;
    }

    public void setNumeroDeFecha(Integer numeroDeFecha) {
        this.numeroDeFecha = numeroDeFecha;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }

    @Override
    public String toString() {
        return "Fecha{" +
                "id=" + id +
                ", numeroDeFecha=" + numeroDeFecha +
                ", partidos=" + partidos +
                '}';
    }
}
