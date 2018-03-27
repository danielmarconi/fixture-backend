package com.fixt.fixture.Services;

import com.fixt.fixture.model.Equipo;
import com.fixt.fixture.model.Usuario;
import com.fixt.fixture.repositories.EquipoRepository;
import com.fixt.fixture.repositories.TorneoRepository;
import com.fixt.fixture.repositories.UsuarioRepository;
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


    @Transactional
    public void inicializarBaseDeDatos() {

        Equipo lanus = new Equipo("Lanus", "aa");

        equipoRepository.save(lanus);

        Usuario kevin = new Usuario("Kevin", lanus);

        usuarioRepository.save(kevin);

        Equipo independiente = new Equipo("Independiente", "aa");

        equipoRepository.save(independiente);

        Usuario gonza = new Usuario("Gonza", independiente);

        usuarioRepository.save(gonza);

        Equipo racing = new Equipo("Racing", "aa");

        equipoRepository.save(racing);

        Usuario alito = new Usuario("Alito", racing);

        usuarioRepository.save(alito);

        Equipo boca = new Equipo("Boca", "aa");

        equipoRepository.save(boca);

        Usuario nahue = new Usuario("Nahue", boca);

        usuarioRepository.save(nahue);


    }

    public List<Equipo> obtenerTodosLosEquipos() {
        return (List<Equipo>) equipoRepository.findAll();
    }
}


