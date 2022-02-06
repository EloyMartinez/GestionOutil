package com.example.gestionoutil.dao;

import com.example.gestionoutil.entity.MyLocationEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class LocationDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionOutil");

    public void save(MyLocationEntity location){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        if (location.getIdloc() == 0)
            em.persist(location);
        else
            em.merge(location);
        et.commit();
    }

    public List<MyLocationEntity> getAll(){
        EntityManager em = emf.createEntityManager();
        return em.createNativeQuery("select * from location", MyLocationEntity.class).getResultList();
    }

    public MyLocationEntity getById(int id){
        EntityManager em = emf.createEntityManager();
        return em.find(MyLocationEntity.class, id);
    }

    public void delete(int id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.remove(em.find(MyLocationEntity.class, id));
        et.commit();
    }
}
