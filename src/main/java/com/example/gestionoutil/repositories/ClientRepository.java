package com.example.gestionoutil.repositories;

import com.example.gestionoutil.entity.MyClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends JpaRepository<MyClientEntity, Long> {
    @Query("SELECT c FROM MyClientEntity c WHERE c.courrielcli = ?1")
    MyClientEntity getClientByEmail(@Param("courriel") String courriel);

}
