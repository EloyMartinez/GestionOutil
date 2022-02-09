package com.example.gestionoutil.repositories;

import com.example.gestionoutil.entity.MyAdminEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AdminRepository extends CrudRepository<MyAdminEntity, Long> {
    @Query("SELECT c FROM MyAdminEntity c WHERE c.courrieladmin = :courriel")
    MyAdminEntity getAdmintByEmail(@Param("courriel") String courriel);
}
