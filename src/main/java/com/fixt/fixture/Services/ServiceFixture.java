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


    @Transactional
    public void inicializarBaseDeDatos() {

        Equipo lanus = new Equipo("Lanus", "aa");
        Equipo independiente = new Equipo("Independiente", "aa");
        Equipo racing = new Equipo("Racing", "aa");
        Equipo boca = new Equipo("Boca", "aa");

        equipoRepository.save(lanus);
        equipoRepository.save(independiente);
        equipoRepository.save(racing);
        equipoRepository.save(boca);

        Usuario kevin = new Usuario("Kevin", lanus);
        Usuario gonza = new Usuario("Gonza", independiente);
        Usuario alito = new Usuario("Alito", racing);
        Usuario nahue = new Usuario("Nahue", boca);

        usuarioRepository.save(kevin);
        usuarioRepository.save(gonza);
        usuarioRepository.save(alito);
        usuarioRepository.save(nahue);

        Partido lanusIndependiente = new Partido(lanus, independiente);
        Partido racingBoca = new Partido(racing, boca);

        partidoRepository.save(lanusIndependiente);
        partidoRepository.save(racingBoca);

        Fecha fecha1 = new Fecha(1);

        fecha1.agregarPartido(lanusIndependiente);
        fecha1.agregarPartido(racingBoca);

        fechaRepository.save(fecha1);

        Torneo ligaA = new Torneo("Copa liga A");

        ligaA.agregarFechas(fecha1);

        torneoRepository.save(ligaA);

    }

    public List<Equipo> obtenerTodosLosEquipos() {
        return (List<Equipo>) equipoRepository.findAll();
    }
}


