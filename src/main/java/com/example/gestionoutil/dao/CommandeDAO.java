package com.example.gestionoutil.dao;

import com.example.gestionoutil.entity.MyCommandeEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class CommandeDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionOutil");

    public void save(MyCommandeEntity commande){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        if (commande.getIdcom() == 0)
            em.persist(commande);
        else
            em.merge(commande);
        et.commit();
    }

    public List<MyCommandeEntity> getAll(){
        EntityManager em = emf.createEntityManager();
        return em.createNativeQuery("select * from commande", MyCommandeEntity.class).getResultList();
    }

    public MyCommandeEntity getById(int id){
        EntityManager em = emf.createEntityManager();
        return em.find(MyCommandeEntity.class, id);
    }

    public void delete(int id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.remove(em.find(MyCommandeEntity.class, id));
        et.commit();
    }
}
