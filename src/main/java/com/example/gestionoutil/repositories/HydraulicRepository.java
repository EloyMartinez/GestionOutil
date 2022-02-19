package com.example.gestionoutil.repositories;

import com.example.gestionoutil.entity.MyElectriqueEntity;
import com.example.gestionoutil.entity.MyHydrauliqueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface HydraulicRepository extends JpaRepository<MyHydrauliqueEntity, Long> {
    @Query("SELECT s FROM MyHydrauliqueEntity s WHERE s.nomoutil like %:keyword%")
    List<MyHydrauliqueEntity> findByKeyword(@Param("keyword") String keyword);
}
