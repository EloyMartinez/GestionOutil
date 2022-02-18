package com.example.gestionoutil.dao;

import com.example.gestionoutil.entity.MyParticulierEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class ParticulierDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionOutil");

    public void save(MyParticulierEntity particulier){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        if (particulier.getIdpar() == 0)
            em.persist(particulier);
        else
            em.merge(particulier);
        et.commit();
    }

    public List<MyParticulierEntity> getAll(){
        EntityManager em = emf.createEntityManager();
        return em.createNativeQuery("select * from particulier", MyParticulierEntity.class).getResultList();
    }

    public MyParticulierEntity getById(Long id){
        EntityManager em = emf.createEntityManager();
        return em.find(MyParticulierEntity.class, id);
    }

    public void delete(Long id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.remove(em.find(MyParticulierEntity.class, id));
        et.commit();
    }
}
