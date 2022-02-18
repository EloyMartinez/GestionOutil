package com.example.gestionoutil.dao;

import com.example.gestionoutil.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class InventaireDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionOutil");

    public void save(MyInventaireEntity inventaire){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        if (inventaire.getIdinv() == 0)
            em.persist(inventaire);
        else
            em.merge(inventaire);
        et.commit();
    }

    public List<MyInventaireEntity> getAll(){
        EntityManager em = emf.createEntityManager();
        return em.createNativeQuery("select * from inventaire", MyInventaireEntity.class).getResultList();
    }

    public MyInventaireEntity getById(Long id){
        EntityManager em = emf.createEntityManager();
        return em.find(MyInventaireEntity.class, id);
    }

    public void delete(Long id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.remove(em.find(MyInventaireEntity.class, id));
        et.commit();
    }
}
