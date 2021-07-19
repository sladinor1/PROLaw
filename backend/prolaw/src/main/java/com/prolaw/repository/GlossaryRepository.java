package com.prolaw.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

import com.prolaw.domain.Glossary;
public interface GlossaryRepository  extends CrudRepository<Glossary,Long> {

    Glossary findByNameGlo(@Param("nombre_glo") String nameGlo);
    List<Glossary> findByInitial(@Param("inicial_glo") char initial);
}
