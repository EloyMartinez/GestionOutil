package com.example.gestionoutil.services;

import com.example.gestionoutil.entity.MyElectriqueEntity;
import com.example.gestionoutil.repositories.ElectricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElecService {

    @Autowired
    private ElectricRepository repository;

    /*
     * TODO: Get the List of Shops
     */
    public List<MyElectriqueEntity> getAll(){
        List<MyElectriqueEntity> list =  (List<MyElectriqueEntity>)repository.findAll();
        return list;
    }

    /*
     * TODO: Get Shop By keyword
     */
    public List<MyElectriqueEntity> getByKeyword(String keyword){
        return repository.findByKeyword(keyword);
    }
}
