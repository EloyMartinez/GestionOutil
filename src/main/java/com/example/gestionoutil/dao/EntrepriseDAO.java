package com.example.gestionoutil.dao;

import com.example.gestionoutil.entity.MyEntrepriseEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class EntrepriseDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionOutil");

    public void save(MyEntrepriseEntity entreprise){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        if (entreprise.getIden() == 0)
            em.persist(entreprise);
        else
            em.merge(entreprise);
        et.commit();
    }

    public List<MyEntrepriseEntity> getAll(){
        EntityManager em = emf.createEntityManager();
        return em.createNativeQuery("select * from entreprise", MyEntrepriseEntity.class).getResultList();
    }

    public MyEntrepriseEntity getById(Long id){
        EntityManager em = emf.createEntityManager();
        return em.find(MyEntrepriseEntity.class, id);
    }

    public void delete(Long id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.remove(em.find(MyEntrepriseEntity.class, id));
        et.commit();
    }
}
