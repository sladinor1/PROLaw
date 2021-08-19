package com.prolaw.repository;

import com.prolaw.domain.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

//import antlr.collections.List;
//import java.util.*;



public interface UserRepository extends CrudRepository<User,String> {

    User findByIdUser(@Param("idUser") String idUser);
    User findByNameUser(@Param("nameUser") String nameUser);
    User findByLastNameUser(@Param("lastNameUser") String lastNameUser);
    User findByCelUser(@Param("celUser") String celUser);
    User findByEmailUser(@Param("emailUser") String emailUser);
    User findByPassUser(@Param("passUser") String passUser);

}
