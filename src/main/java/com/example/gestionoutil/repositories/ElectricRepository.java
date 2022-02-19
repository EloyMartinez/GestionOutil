package com.example.gestionoutil.repositories;

import com.example.gestionoutil.entity.MyClientEntity;
import com.example.gestionoutil.entity.MyElectriqueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElectricRepository extends JpaRepository<MyElectriqueEntity, Long> {
    @Query("SELECT s FROM MyElectriqueEntity s WHERE s.nomoutil like %:keyword%")
    List<MyElectriqueEntity> findByKeyword(@Param("keyword") String keyword);
}
