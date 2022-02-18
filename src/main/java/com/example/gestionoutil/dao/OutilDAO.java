package com.example.gestionoutil.dao;

import com.example.gestionoutil.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class OutilDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionOutil");

    public void save(MyOutilEntity outil){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        if (outil.getIdoutil() == 0)
            em.persist(outil);
        else
            em.merge(outil);
        et.commit();
    }

    public List<MyOutilEntity> getAll(){
        EntityManager em = emf.createEntityManager();
        return em.createNativeQuery("select * from outil", MyOutilEntity.class).getResultList();
    }

    public MyOutilEntity getById(Long id){
        EntityManager em = emf.createEntityManager();
        return em.find(MyOutilEntity.class, id);
    }

    public void delete(Long id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.remove(em.find(MyOutilEntity.class, id));
        et.commit();
    }
}
