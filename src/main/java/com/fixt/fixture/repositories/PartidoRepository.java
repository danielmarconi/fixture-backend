package com.fixt.fixture.repositories;

import com.fixt.fixture.model.Partido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by kevinvarela on 28/03/18.
 */

@Transactional
public interface PartidoRepository extends CrudRepository<Partido, Long> {

}
