package com.example.gestionoutil;

import com.example.gestionoutil.dao.ClientDAO;
import com.example.gestionoutil.entity.MyClientEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class GestionOutilApplication {
    public static void main(String[] args) {
        SpringApplication.run(GestionOutilApplication.class, args);
        System.out.println(new BCryptPasswordEncoder().encode("azert"));
    }
}
