package com.example.gestionoutil.controllers;

import com.example.gestionoutil.dao.ClientDAO;
import com.example.gestionoutil.entity.MyAdminEntity;
import com.example.gestionoutil.entity.MyClientEntity;
import com.example.gestionoutil.repositories.AdminRepository;
import com.example.gestionoutil.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AdminRepository adminRepository;

    @GetMapping("")
    public String viewHomePage(){
        return "login";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        List<MyClientEntity> listClient = clientRepository.findAll();
        model.addAttribute("listClients", listClient);
        return "admin";
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


    @PostMapping("/process_register")
    public String processRegister(MyClientEntity client) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        client.setMdpcli(passwordEncoder.encode(client.getMdpcli()));
        ClientDAO clientDAO= new ClientDAO();
        clientDAO.save(client);
        return "register_success";
    }


}
