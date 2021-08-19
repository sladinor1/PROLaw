package com.prolaw.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.prolaw.domain.Lawyer;
//import antlr.collections.List;
//import java.util.*;



public interface LawyerRepository extends CrudRepository<Lawyer,String> {

    Lawyer findByIdUser(@Param("idUser") String idUser);
    Lawyer findByIdLaw(@Param("idLaw") String idLaw);
    Lawyer findByEspeLaw(@Param("espeLaw") String espeLaw);

}
