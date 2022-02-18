package com.example.gestionoutil;

import com.example.gestionoutil.dao.ClientDAO;
import com.example.gestionoutil.entity.MyClientEntity;
import com.example.gestionoutil.entity.MyCommandeEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import sun.security.acl.AclEntryImpl;

@SpringBootApplication
public class GestionOutilApplication {
    public static void main(String[] args) {
        SpringApplication.run(GestionOutilApplication.class, args);

        /*ClientDAO clientDAO = new ClientDAO();
        MyClientEntity client = new MyClientEntity();
        client.setNomcli("nom");
        client.setPrenomcli("prenom");
        client.setAdmin(false);
        client.setCourrielcli("courriel");

        clientDAO.save(client);*/
    }
}
