package com.example.gestionoutil.repositories;

import com.example.gestionoutil.entity.MyElectriqueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectricRepository extends JpaRepository<MyElectriqueEntity, Long> {
}
