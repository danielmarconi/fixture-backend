package com.fixt.fixture.repositories;

import com.fixt.fixture.model.Equipo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by kevinvarela on 16/03/18.
 */

@Transactional
public interface EquipoRepository extends CrudRepository<Equipo, Long> {

}
