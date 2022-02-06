package com.example.gestionoutil;

import com.example.gestionoutil.entity.MyActeurEntity;


import javax.persistence.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("GestionOutil");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            MyActeurEntity a = new MyActeurEntity();
            a.setIda(1);
            a.setNoma("E");
            a.setPrenoma("e");
            System.out.println("hello");
            entityManager.merge(a);


            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}