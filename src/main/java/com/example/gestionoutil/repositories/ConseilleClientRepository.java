package com.example.gestionoutil.repositories;

import com.example.gestionoutil.entity.MyConseilleClientEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ConseilleClientRepository extends CrudRepository<MyConseilleClientEntity, Long> {
    @Query("SELECT c FROM MyConseilleClientEntity c WHERE c.courrielcc = :courriel")
    public MyConseilleClientEntity getConseilleByEmail(@Param("courriel") String courriel);
}
