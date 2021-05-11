package com.prolaw.repository;

import com.prolaw.domain.Subcategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
//import java.util.List;

public interface SubCategoryRepository extends CrudRepository<Subcategory,Long>{
    Subcategory findByNameSubcat(@Param("nombre_sub") String nameSubcat);
    Subcategory findByIdSubcat(@Param("id_sub") Long idSubcat);
}
