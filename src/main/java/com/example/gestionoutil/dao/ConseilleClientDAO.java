package com.example.gestionoutil.dao;

import com.example.gestionoutil.entity.MyConseilleClientEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class ConseilleClientDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionOutil");

    public void save(MyConseilleClientEntity conseilleClient){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        if (conseilleClient.getIdco() == 0)
            em.persist(conseilleClient);
        else
            em.merge(conseilleClient);
        et.commit();
    }

    public List<MyConseilleClientEntity> getAll(){
        EntityManager em = emf.createEntityManager();
        return em.createNativeQuery("select * from conseilleClient", MyConseilleClientEntity.class).getResultList();
    }

    public MyConseilleClientEntity getById(Long id){
        EntityManager em = emf.createEntityManager();
        return em.find(MyConseilleClientEntity.class, id);
    }

    public void delete(Long id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.remove(em.find(MyConseilleClientEntity.class, id));
        et.commit();
    }
}
