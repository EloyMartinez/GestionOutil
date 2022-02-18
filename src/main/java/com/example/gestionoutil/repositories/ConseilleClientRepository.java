package com.example.gestionoutil.repositories;

import com.example.gestionoutil.entity.MyConseilleClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ConseilleClientRepository extends JpaRepository<MyConseilleClientEntity, Long> {
    @Query("SELECT c FROM MyConseilleClientEntity c WHERE c.courrielcc = :courriel")
    MyConseilleClientEntity getConseilleByEmail(@Param("courriel") String courriel);
}