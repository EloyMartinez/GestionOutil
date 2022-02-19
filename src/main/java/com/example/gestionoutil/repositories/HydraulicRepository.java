package com.example.gestionoutil.repositories;

import com.example.gestionoutil.entity.MyElectriqueEntity;
import com.example.gestionoutil.entity.MyHydrauliqueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface HydraulicRepository extends JpaRepository<MyHydrauliqueEntity, Long> {
}
