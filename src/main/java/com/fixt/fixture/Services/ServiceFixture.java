package com.fixt.fixture.Services;

import com.fixt.fixture.model.*;
import com.fixt.fixture.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by kevinvarela on 26/03/18.
 */

@Service
public class ServiceFixture {

    @Autowired
    private EquipoRepository equipoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TorneoRepository torneoRepository;

    @Autowired
    private FechaRepository fechaRepository;

    @Autowired
    private PartidoRepository partidoRepository;

    @Autowired
    private TablaRepository tablaRepository;

    @Autowired
    private CalculadorDeResultados calculadorDeResultados;

    @Transactional
    public void inicializarBaseDeDatos() {

        //CREAR EQUIPO (NOMBRE, IMAGEN)

        Equipo lanus = new Equipo("Lanus", "aa");
        Equipo independiente = new Equipo("Independiente", "aa");
        Equipo racing = new Equipo("Racing", "aa");
        Equipo boca = new Equipo("Boca", "aa");

        equipoRepository.save(lanus);
        equipoRepository.save(independiente);
        equipoRepository.save(racing);
        equipoRepository.save(boca);

        //CREAR USUARIO (NOMBRE_USUARIO, EQUIPO)

        Usuario kevin = new Usuario("Kevin", lanus);
        Usuario gonza = new Usuario("Gonza", independiente);
        Usuario alito = new Usuario("Alito", racing);
        Usuario nahue = new Usuario("Nahue", boca);

        usuarioRepository.save(kevin);
        usuarioRepository.save(gonza);
        usuarioRepository.save(alito);
        usuarioRepository.save(nahue);

        //CREAR PARTIDOS (EQUIPO1, EQUIPO2)

        Partido lanusIndependiente = new Partido(lanus, independiente);
        Partido racingBoca = new Partido(racing, boca);

        //AL HABER JUGADO UN PARTIDO => unPartido.cargarResultadosPartido(resultadoLocal, resultadoVisitante)

        partidoRepository.save(lanusIndependiente);
        partidoRepository.save(racingBoca);

        //CREAR UNA FECHA (NUMERO DE FECHA)
        Fecha fecha1 = new Fecha(1);

        //AGREGAR PARTIDO A FECHA (PARTIDO)
        fecha1.agregarPartido(lanusIndependiente);
        fecha1.agregarPartido(racingBoca);

        fechaRepository.save(fecha1);

        //CREAR TORNEO (NOMBRE TORNEO)
        Torneo ligaA = new Torneo("Copa liga A");

        //AGREGAR FECHAS A TORNEO (FECHA)
        ligaA.agregarFechas(fecha1);

        torneoRepository.save(ligaA);

        EquipoEnTabla uno = new EquipoEnTabla(independiente, 0, 0, 0, 0, 0, 0);
        EquipoEnTabla dos = new EquipoEnTabla(racing, 0, 0, 0, 0, 0, 0);
        EquipoEnTabla tres = new EquipoEnTabla(boca, 0, 0, 0, 0, 0, 0);
        EquipoEnTabla cuatro = new EquipoEnTabla(lanus, 0, 0, 0, 0, 0, 0);

        tablaRepository.save(uno);
        tablaRepository.save(dos);
        tablaRepository.save(tres);
        tablaRepository.save(cuatro);

    }

    public List<Equipo> obtenerTodosLosEquipos() {
        return (List<Equipo>) equipoRepository.findAll();
    }

    public List<EquipoEnTabla> obtenerTodosLosEquiposEnTabla() {
        return (List<EquipoEnTabla>) tablaRepository.findAll();
    }

    public List<Partido> obtenerTodosLosPartidos() {
        return (List<Partido>) partidoRepository.findAll();
    }

    public Partido cargarResultadosPartido(Long idPartido, Integer resultadoLocal, Integer resultadoVisitante){
        return calculadorDeResultados.cargarResultadosPartido(idPartido, resultadoLocal, resultadoVisitante);
    }

}


