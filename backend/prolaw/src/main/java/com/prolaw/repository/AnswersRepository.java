package com.prolaw.repository;


import com.prolaw.domain.Answers;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AnswersRepository extends CrudRepository<Answers,Long>{
    Answers findByIdAns(@Param("id_ans") long idAns);
}
