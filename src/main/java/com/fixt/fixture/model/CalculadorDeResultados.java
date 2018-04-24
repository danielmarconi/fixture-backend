package com.fixt.fixture.model;

import com.fixt.fixture.repositories.PartidoRepository;
import com.fixt.fixture.repositories.TablaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by kevinvarela on 24/04/18.
 */
@Service
public class CalculadorDeResultados {

    @Autowired
    private PartidoRepository partidoRepository;

    @Autowired
    private TablaRepository tablaRepository;

    public Partido cargarResultadosPartido(Long idPartido, Integer resultadoLocal, Integer resultadoVisitante){
        Optional<Partido> partidoAActualizar = partidoRepository.findById(idPartido);
        try{
            partidoAActualizar.ifPresent(partido -> partido.cargarResultado(resultadoLocal, resultadoVisitante));
            Partido partidoActualizado = partidoAActualizar.get();
            partidoRepository.save(partidoActualizado);
            actualizarTablaDelTorneo(partidoActualizado);
            return partidoActualizado;
        }catch (Exception e){
            throw new RuntimeException("No se pudo actualizar el partido", e);
        }
    }

    private void actualizarTablaDelTorneo(Partido partidoACargar) {
        if(partidoACargar.noFueEmpatado()){
            Equipo equipoGanador = partidoACargar.equipoGanador();
            EquipoEnTabla equipoGanadorEnTabla = tablaRepository.findById(equipoGanador.getId()).get();
            equipoGanadorEnTabla.ganar(partidoACargar.golesGanador());
            tablaRepository.save(equipoGanadorEnTabla);

            Equipo equipoPerdedor = partidoACargar.equipoPerdedor();
            EquipoEnTabla equipoPerdedorEnTabla = tablaRepository.findById(equipoPerdedor.getId()).get();
            equipoPerdedorEnTabla.perder(partidoACargar.golesPerdedor());
            tablaRepository.save(equipoPerdedorEnTabla);

        }else {
            Equipo equipoLocal = partidoACargar.local;
            Equipo equipoVisitante = partidoACargar.visitante;

            EquipoEnTabla equipoLocalEnTabla = tablaRepository.findById(equipoLocal.getId()).get();
            EquipoEnTabla equipoVisitanteEnTabla = tablaRepository.findById(equipoVisitante.getId()).get();

            equipoLocalEnTabla.empatar(partidoACargar.golesLocal);
            tablaRepository.save(equipoLocalEnTabla);
            equipoVisitanteEnTabla.empatar(partidoACargar.golesVisitante);
            tablaRepository.save(equipoVisitanteEnTabla);
        }
    }

}