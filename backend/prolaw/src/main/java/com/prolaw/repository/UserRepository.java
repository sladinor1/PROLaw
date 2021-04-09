package com.prolaw.repository;

import com.prolaw.domain.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

//import antlr.collections.List;
import java.util.*;

/* Atributos
private String nameUser;
    private String lastNameUser;
    private Integer celUser;
    private String emailUser;
    private String passUser;
*/

public interface UserRepository extends CrudRepository<User,Long> {

    List<User> findByIdUser(@Param("idUser") Long idUser);
    List<User> findByNameUser(@Param("nameUser") String nameUser);
    List<User> findByLastNameUser(@Param("lastNameUser") String lastNameUser); 
    List<User> findByCelUser(@Param("celUser") String celUser);
    List<User> findByEmailUser(@Param("emailUser") String emailUser);   
    List<User> findByPassUser(@Param("passUser") String passUser); 
}
