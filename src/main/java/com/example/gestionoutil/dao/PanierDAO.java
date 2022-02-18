package com.example.gestionoutil.dao;

import com.example.gestionoutil.entity.MyPanierEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class PanierDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionOutil");

    public void save(MyPanierEntity panier){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        if (panier.getIdpanier() == 0)
            em.persist(panier);
        else
            em.merge(panier);
        et.commit();
    }

    public List<MyPanierEntity> getAll(){
        EntityManager em = emf.createEntityManager();
        return em.createNativeQuery("select * from panier", MyPanierEntity.class).getResultList();
    }

    public MyPanierEntity getById(Long id){
        EntityManager em = emf.createEntityManager();
        return em.find(MyPanierEntity.class, id);
    }

    public void deletePanier(Long id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.remove(em.find(MyPanierEntity.class, id));
        et.commit();
    }
}
