package com.fixt.fixture.controllers;

import com.fixt.fixture.util.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by kevinvarela on 06/03/18.
 */
@Controller
public class MainController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

//    @RequestMapping(value = "/book", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @ResponseStatus(value = HttpStatus.OK)
//    @ResponseBody
//    public CompraFinalDTO reservarPaqueteDeVuelos(@RequestBody ViajeDTO viajeDTO) {
//
//        LOGGER.info("Request: [POST] /BOOK - Body: " + viajeDTO);
//
//        return method();
//    }
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
}
