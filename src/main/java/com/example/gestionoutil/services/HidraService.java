package com.example.gestionoutil.services;

import com.example.gestionoutil.entity.MyElectriqueEntity;
import com.example.gestionoutil.entity.MyHydrauliqueEntity;
import com.example.gestionoutil.repositories.ElectricRepository;
import com.example.gestionoutil.repositories.HydraulicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HidraService {

    @Autowired
    private HydraulicRepository repository;

    /*
     * TODO: Get the List of Shops
     */
    public List<MyHydrauliqueEntity> getAll(){
        List<MyHydrauliqueEntity> list =  (List<MyHydrauliqueEntity>)repository.findAll();
        return list;
    }

    /*
     * TODO: Get Shop By keyword
     */
    public List<MyHydrauliqueEntity> getByKeyword(String keyword){
        return repository.findByKeyword(keyword);
    }
}
