package com.example.gestionoutil.repositories;

import com.example.gestionoutil.entity.MyAdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AdminRepository extends JpaRepository<MyAdminEntity, Long> {
    @Query("SELECT c FROM MyAdminEntity c WHERE c.courrieladmin = :courriel")
    MyAdminEntity getAdmintByEmail(@Param("courriel") String courriel);
}
