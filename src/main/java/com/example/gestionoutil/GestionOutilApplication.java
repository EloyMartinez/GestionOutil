package com.example.gestionoutil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.Date;

@SpringBootApplication
public class GestionOutilApplication {
    public static void main(String[] args) {
        SpringApplication.run(GestionOutilApplication.class, args);


        /*ClientDAO clientDAO = new ClientDAO();
        MyClientEntity client = new MyClientEntity();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        client.setNomcli("nom");
        client.setPrenomcli("prenom");
        client.setAdmin(false);
        client.setCourrielcli("courriel");
        client.setMdpcli(passwordEncoder.encode("azert"));
        client.setTelephonecli("56465");
        client.setDatenaissancecli(new Date(1,1,1));

        MyClientEntity client1 = new MyClientEntity();
        client1.setNomcli("admin");
        client1.setPrenomcli("admin");
        client1.setAdmin(true);
        client1.setCourrielcli("admin@mail.com");
        client1.setMdpcli(passwordEncoder.encode("azert"));
        client1.setTelephonecli("56465");
        client1.setDatenaissancecli(new Date(1,1,1));


        clientDAO.save(client);
        clientDAO.save(client1);*/
    }
}
