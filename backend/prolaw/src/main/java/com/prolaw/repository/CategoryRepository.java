package com.prolaw.repository;
import com.prolaw.domain.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
//import java.util.List;

public interface CategoryRepository extends CrudRepository<Category,Long>{
    Category findByNameCate(@Param("nombre_ar") String nameCate);
    Category findByIdCate(@Param("id_ar") Long idCate);
}
