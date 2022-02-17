package com.example.gestionoutil.controllers;

import com.example.gestionoutil.dao.ClientDAO;
import com.example.gestionoutil.entity.MyClientEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

    @GetMapping("")
    public String viewHomePage(){
        return "login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("client", new MyClientEntity());
        return "register";
    }

    @GetMapping("/users")
    public String users() {
        return "users";
    }


    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @PostMapping("/process_register")
    public String processRegister(MyClientEntity client) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        client.setMdpcli(passwordEncoder.encode(client.getMdpcli()));
        ClientDAO clientDAO= new ClientDAO();
        clientDAO.save(client);

        return "register_success";
    }


}
