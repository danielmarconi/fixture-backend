package com.fixt.fixture.repositories;

import com.fixt.fixture.model.EquipoEnTabla;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by kevinvarela on 13/04/18.
 */
public interface TablaRepository extends CrudRepository<EquipoEnTabla, Long> {

    //select nombre, diferencia_de_goles, partidos_empatados,partidos_ganados,partidos_jugados,partidos_perdidos,puntos from equipo_en_tabla et join equipo e where et.equipo_id = e.id

}
