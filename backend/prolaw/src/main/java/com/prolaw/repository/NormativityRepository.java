package com.prolaw.repository;

import com.prolaw.domain.Normativity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
//import java.util.List;

public interface NormativityRepository extends CrudRepository<Normativity,Long> {
    Normativity findByNameNor(@Param("nombre_nor") String nameNor);
    Normativity findByIdNor(@Param("id_nor") Long idNor);
}
