package com.example.gestionoutil.dao;

import com.example.gestionoutil.entity.MyAchatEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class AchatDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionOutil");

    public void save(MyAchatEntity achat){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        if (achat.getIdachat() == 0)
            em.persist(achat);
        else
            em.merge(achat);
        et.commit();
    }

    public List<MyAchatEntity> getAll(){
        EntityManager em = emf.createEntityManager();
        return em.createNativeQuery("select * from achat", MyAchatEntity.class).getResultList();
    }

    public MyAchatEntity getById(int id){
        EntityManager em = emf.createEntityManager();
        return em.find(MyAchatEntity.class, id);
    }

    public void deleteAchat(int id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.remove(em.find(MyAchatEntity.class, id));
        et.commit();
    }
}
