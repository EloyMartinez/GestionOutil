package com.example.gestionoutil.dao;

import com.example.gestionoutil.entity.MyElectriqueEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class ElectriqueDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionOutil");

    public void save(MyElectriqueEntity electrique){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        if (electrique.getIdelec() == null)
            em.persist(electrique);
        else
            em.merge(electrique);
        et.commit();
    }

    public List<MyElectriqueEntity> getAll(){
        EntityManager em = emf.createEntityManager();
        return em.createNativeQuery("select * from electrique", MyElectriqueEntity.class).getResultList();
    }

    public MyElectriqueEntity getById(Long id){
        EntityManager em = emf.createEntityManager();
        return em.find(MyElectriqueEntity.class, id);
    }

    public List<MyElectriqueEntity> getByKeyword(String keyword){
        EntityManager em = emf.createEntityManager();
        return em.createNativeQuery("select * from electrique where nomoutil like '%" + keyword + "%'").getResultList();
    }

    public void delete(Long id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.remove(em.find(MyElectriqueEntity.class, id));
        et.commit();
    }
}
