package com.fixt.fixture.repositories;

import com.fixt.fixture.model.Torneo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by kevinvarela on 16/03/18.
 */

@Transactional
public interface TorneoRepository extends CrudRepository<Torneo, Long> {

}
