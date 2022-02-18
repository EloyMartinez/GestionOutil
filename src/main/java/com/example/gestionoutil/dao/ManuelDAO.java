package com.example.gestionoutil.dao;

import com.example.gestionoutil.entity.MyManuelEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class ManuelDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionOutil");

    public void save(MyManuelEntity manuel){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        if (manuel.getIdmanuel() == 0)
            em.persist(manuel);
        else
            em.merge(manuel);
        et.commit();
    }

    public List<MyManuelEntity> getAll(){
        EntityManager em = emf.createEntityManager();
        return em.createNativeQuery("select * from manuel", MyManuelEntity.class).getResultList();
    }

    public MyManuelEntity getById(Long id){
        EntityManager em = emf.createEntityManager();
        return em.find(MyManuelEntity.class, id);
    }

    public void delete(Long id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.remove(em.find(MyManuelEntity.class, id));
        et.commit();
    }
}
