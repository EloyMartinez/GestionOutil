package com.example.gestionoutil.dao;

import com.example.gestionoutil.entity.MyClientEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class ClientDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionOutil");

    public ClientDAO() {

    }

    public void save(MyClientEntity client){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        if (client.getIdcli() == null)
            em.persist(client);
        else
            em.merge(client);
        et.commit();
    }

    public List<MyClientEntity> getAll(){
        EntityManager em = emf.createEntityManager();
        return em.createNativeQuery("select * from client", MyClientEntity.class).getResultList();
    }

    public MyClientEntity getById(int id){
        EntityManager em = emf.createEntityManager();
        return em.find(MyClientEntity.class, id);
    }

    public void delete(int id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.remove(em.find(MyClientEntity.class, id));
        et.commit();
    }
}
