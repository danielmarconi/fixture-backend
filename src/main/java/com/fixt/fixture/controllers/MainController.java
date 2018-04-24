package com.fixt.fixture.controllers;

import com.fixt.fixture.Services.ServiceFixture;
import com.fixt.fixture.Services.dto.ResultadoPartido;
import com.fixt.fixture.model.Equipo;
import com.fixt.fixture.model.EquipoEnTabla;
import com.fixt.fixture.model.Partido;
import com.fixt.fixture.util.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by kevinvarela on 06/03/18.
 */
@Controller
public class MainController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private ServiceFixture serviceFixture;

//
//    @RequestMapping(value = "/destinations", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @ResponseStatus(value = HttpStatus.OK)
//    @ResponseBody
//    public Collection<CompraFinalDTO> obtenerTopDestinations(@RequestParam(value = "from") String ciudadOrigen) {
//
//        LOGGER.info("Request: [GET] /DESTINATIONS - {}", viaje);
//
//        return servicioDeReservas.obtenerTopDestinations(viaje);
//    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody()
    public Status health(){
        Status status = new Status("OK");
        LOGGER.info("Return Status: {}", status.getStatus());
        return status;
    }

    @RequestMapping(value = "/teams", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public List<Equipo> obtenerTodosLosEquipos() {

        LOGGER.info("Request: [GET] /teams");

        return serviceFixture.obtenerTodosLosEquipos();
    }

    @RequestMapping(value = "/table", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public List<EquipoEnTabla> obtenerTabla() {

        LOGGER.info("Request: [GET] /table");

        return serviceFixture.obtenerTodosLosEquiposEnTabla();
    }

    @RequestMapping(value = "/matches", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public List<Partido> obtenerPartidos() {

        LOGGER.info("Request: [GET] /matches");

        return serviceFixture.obtenerTodosLosPartidos();
    }


    @RequestMapping(value = "/match", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public Partido reservarPaqueteDeVuelos(@RequestBody ResultadoPartido resultadoPartido) {

        LOGGER.info("Request: [POST] /match - Body: " + resultadoPartido);

        return serviceFixture.cargarResultadosPartido(resultadoPartido.getIdPartido(),
                                                      resultadoPartido.getGolesLocal(),
                                                      resultadoPartido.getGolesVisitante());
    }
}
