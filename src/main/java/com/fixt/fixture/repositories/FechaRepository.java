package com.fixt.fixture.repositories;

import com.fixt.fixture.model.Fecha;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by kevinvarela on 28/03/18.
 */

@Transactional
public interface FechaRepository extends CrudRepository<Fecha, Long> {

}
