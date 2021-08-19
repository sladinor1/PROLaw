package com.prolaw.repository;

import com.prolaw.domain.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
public interface NotificationRepository extends CrudRepository<Notification,Long>{
    Notification findByIdNots(@Param("id_not") long id_not);
    //Notification findByIdUs(@Param("id_user") String idUser);
}