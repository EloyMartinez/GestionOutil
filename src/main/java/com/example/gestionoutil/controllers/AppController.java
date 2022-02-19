package com.example.gestionoutil.controllers;

import com.example.gestionoutil.dao.ClientDAO;
import com.example.gestionoutil.dao.ElectriqueDAO;
import com.example.gestionoutil.entity.MyClientEntity;
import com.example.gestionoutil.entity.MyElectriqueEntity;
import com.example.gestionoutil.repositories.ElectricRepository;
import com.example.gestionoutil.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ElectricRepository electriqueRepository;

    private ClientDAO clientDAO = new ClientDAO();
    private ElectriqueDAO electiqueDAO = new ElectriqueDAO();

    public static MyClientEntity selectedUser;
    public static MyElectriqueEntity selectedElectrique;

    @GetMapping("")
    public String viewHomePage(){
        return "login";
    }

    @GetMapping("/admin_user")
    public String admin_user(Model model) {
        List<MyClientEntity> listClient = clientRepository.findAll();
        model.addAttribute("listClients", listClient);
        return "admin_user";
    }

    @GetMapping("/admin_product")
    public String admin_product(Model model) {
        List<MyElectriqueEntity> listProduct = electriqueRepository.findAll();
        model.addAttribute("listProduct", listProduct);
        return "admin_product";
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
        client.setAdmin(false);
        clientDAO = new ClientDAO();
        clientDAO.save(client);
        return "register_success";
    }

    @Autowired
    private ElectricRepository eRepo;

    @GetMapping("/list")
    public String showAll(Model model) {
        model.addAttribute("electric", eRepo.findAll());
        return "list";
    }


    @RequestMapping("/description")
    public String description(Model model, MyElectriqueEntity electric) {
        model.addAttribute("elec",electric);

        return "description";
    }

    @RequestMapping("/editUser/{id}")
    public ModelAndView showEditClientForm(@PathVariable(name="id") Long id) {
        ModelAndView mav = new ModelAndView("editUser");

        MyClientEntity client = clientDAO.getById(id);
        selectedUser = client;
        mav.addObject("client", client);
        return mav;
    }

    @PostMapping("/process_edit_user")
    public String processEditUser(MyClientEntity client){
        //client = client avec nouvelles info, mais incompletes
        //selecteduser = client avec anciennes info
        client.edit(selectedUser); //on met les infos manquantes dans user
        clientDAO.save(client);
        return "redirect:/admin";
    }

    @PostMapping("/process_edit_product")
    public String processEditProduct(MyElectriqueEntity electrique){
        //client = client avec nouvelles info, mais incompletes
        //selecteduser = client avec anciennes info
         //on met les infos manquantes dans user
        electrique.edit(selectedElectrique);
        electiqueDAO.save(electrique);
        return "redirect:/admin";
    }

    @RequestMapping("/editProduct/{id}")
    public ModelAndView showEditProductForm(@PathVariable(name="id") Long id) {
        ModelAndView mav = new ModelAndView("editProduct");
        MyElectriqueEntity electrique = electiqueDAO.getById(id);
        selectedElectrique = electrique;
        mav.addObject("electrique", electrique);
        return mav;
    }


    @RequestMapping("/deleteUser/{id}")
    public String deleteClient(@PathVariable(name="id") Long id) {
        clientDAO.delete(id);
        return "redirect:/admin";
    }

    @RequestMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable(name="id") Long id) {
        electiqueDAO.delete(id);
        return "redirect:/admin";
    }

    @GetMapping("/403")
    public String error403()
    {
        return "403";
    }



}
