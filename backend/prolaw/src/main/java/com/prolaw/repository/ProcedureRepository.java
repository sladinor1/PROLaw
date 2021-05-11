package com.prolaw.repository;

import com.prolaw.domain.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
//import java.util.List;

public interface ProcedureRepository extends CrudRepository<Procedure,Long>{
    Procedure findByNamePro(@Param("nombre_tra") String namePro);
    Procedure findByIdPro(@Param("id_tra") Long idPro);
}
