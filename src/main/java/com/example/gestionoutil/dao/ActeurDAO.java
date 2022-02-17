package com.example.gestionoutil.dao;

import com.example.gestionoutil.entity.MyActeurEntity;
import com.example.gestionoutil.entity.MyClientEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class ActeurDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionOutil");


    public void save(MyActeurEntity acteur){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        if (acteur.getIda() == 0)
            em.persist(acteur);
        else
            em.merge(acteur);
        et.commit();
    }

    public List<MyActeurEntity> getAll(){
        EntityManager em = emf.createEntityManager();
        return em.createNativeQuery("select * from acteur", MyActeurEntity.class).getResultList();
    }

    public MyActeurEntity getById(int id){
        EntityManager em = emf.createEntityManager();
        return em.find(MyActeurEntity.class, id);
    }



    public void delete(int id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.remove(em.find(MyActeurEntity.class, id));
        et.commit();
    }
}
