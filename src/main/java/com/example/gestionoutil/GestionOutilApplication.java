package com.example.gestionoutil;

import com.example.gestionoutil.dao.HydrauliqueDAO;
import com.example.gestionoutil.entity.MyHydrauliqueEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
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

        String path = "C:\\Users\\Alexandre\\Pictures\\images";
        String fullPath ="C:\\Users\\Alexandre\\Pictures\\images\\glock.jpg";
        String fileName = "glock.jpg";
        MyHydrauliqueEntity entity = new MyHydrauliqueEntity();
        entity.setNomoutil("glock3");
        entity.setPression(45L);
        entity.setDescription("new glock");
        entity.setPrix(100d);

        try{
            File image = new File(fullPath);
            byte[] imageData = Files.readAllBytes(image.toPath());
            entity.setImage(imageData);
            HydrauliqueDAO dao = new HydrauliqueDAO();
            dao.save(entity);
            System.out.println("image inserted");
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
        }


    }
}
