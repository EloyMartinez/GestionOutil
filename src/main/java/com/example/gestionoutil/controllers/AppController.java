package com.example.gestionoutil.controllers;

import com.example.gestionoutil.entity.MyClientEntity;
import com.example.gestionoutil.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {
    @Autowired
    private ClientRepository clientRepository;

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
        clientRepository.save(client);
        return "register_success";
    }
}
