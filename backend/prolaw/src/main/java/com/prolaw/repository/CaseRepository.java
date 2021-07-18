package com.prolaw.repository;

import java.util.List;

import com.prolaw.domain.Case;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CaseRepository extends CrudRepository<Case,Long>{
    Case findByIdCase(@Param("id_case") long idCase);
    
}
