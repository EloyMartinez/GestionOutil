package com.example.gestionoutil.dao;

import com.example.gestionoutil.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class HydrauliqueDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionOutil");

    public void save(MyHydrauliqueEntity hydraulique){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        if (hydraulique.getIdhyd() == null)
            em.persist(hydraulique);
        else
            em.merge(hydraulique);
        et.commit();
    }

    public List<MyHydrauliqueEntity> getAll(){
        EntityManager em = emf.createEntityManager();
        return em.createNativeQuery("select * from hydraulique", MyHydrauliqueEntity.class).getResultList();
    }

    public MyHydrauliqueEntity getById(Long id){
        EntityManager em = emf.createEntityManager();
        return em.find(MyHydrauliqueEntity.class, id);
    }

    public List<MyHydrauliqueEntity> getByKeyword(String keyword){
        EntityManager em = emf.createEntityManager();
        return em.createNativeQuery("select * from hydraulique where nomoutil like '%" + keyword + "%'").getResultList();
    }

    public void delete(Long id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.remove(em.find(MyHydrauliqueEntity.class, id));
        et.commit();
    }


}
