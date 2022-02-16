package com.example.gestionoutil.repositories;

import com.example.gestionoutil.entity.MyClientEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends CrudRepository<MyClientEntity, Long> {
    @Query("SELECT c FROM MyClientEntity c WHERE c.courrielcli = :courriel")
    MyClientEntity getClientByEmail(@Param("courriel") String courriel);


}
