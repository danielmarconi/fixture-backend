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
        Optional<Partido> partidoPorJugar = partidoRepository.findById(idPartido);
        try{
            if(partidoPorJugar.isPresent() && !partidoPorJugar.get().fueJugado()){
                Partido partido = partidoPorJugar.get();
                partido.cargarResultado(resultadoLocal, resultadoVisitante);
                partidoRepository.save(partido);
                actualizarTablaDelTorneo(partido);
                return partido;
            }else{
                throw new RuntimeException("No se pudo actualizar el partido.");
            }
        }catch (Exception e){
            throw new RuntimeException("El partido que intento cargar no esta para ser jugado.", e);
        }
    }

    private void actualizarTablaDelTorneo(Partido partidoACargar) {

        if(partidoACargar.noFueEmpatado()){

            Equipo equipoGanador = partidoACargar.equipoGanador();
            Equipo equipoPerdedor = partidoACargar.equipoPerdedor();

            EquipoEnTabla equipoGanadorEnTabla = tablaRepository.findById(equipoGanador.getId()).get();
            EquipoEnTabla equipoPerdedorEnTabla = tablaRepository.findById(equipoPerdedor.getId()).get();

            equipoGanadorEnTabla.ganar(partidoACargar);
            equipoPerdedorEnTabla.perder(partidoACargar);

            tablaRepository.save(equipoGanadorEnTabla);
            tablaRepository.save(equipoPerdedorEnTabla);

        }else {
            Equipo equipoLocal = partidoACargar.local;
            Equipo equipoVisitante = partidoACargar.visitante;

            EquipoEnTabla equipoLocalEnTabla = tablaRepository.findById(equipoLocal.getId()).get();
            EquipoEnTabla equipoVisitanteEnTabla = tablaRepository.findById(equipoVisitante.getId()).get();

            equipoLocalEnTabla.empatar();
            equipoVisitanteEnTabla.empatar();
            tablaRepository.save(equipoLocalEnTabla);
            tablaRepository.save(equipoVisitanteEnTabla);
        }
    }

}
