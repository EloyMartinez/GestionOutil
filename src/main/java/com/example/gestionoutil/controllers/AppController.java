package com.example.gestionoutil.controllers;

import com.example.gestionoutil.dao.ClientDAO;
import com.example.gestionoutil.entity.MyClientEntity;
import com.example.gestionoutil.entity.MyElectriqueEntity;
import com.example.gestionoutil.entity.MyHydrauliqueEntity;
import com.example.gestionoutil.repositories.ElectricRepository;
import com.example.gestionoutil.repositories.ClientRepository;
import com.example.gestionoutil.repositories.HydraulicRepository;
import com.example.gestionoutil.services.ElecService;
import com.example.gestionoutil.services.HidraService;
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

    private ClientDAO clientDAO = new ClientDAO();

    public static MyClientEntity selectedUser;

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
        client.setAdmin(false);
        clientDAO = new ClientDAO();
        clientDAO.save(client);
        return "register_success";
    }

    @Autowired
    private ElectricRepository eRepo;

    @Autowired
    private HydraulicRepository hRepo;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("electric", eRepo.findAll());
        model.addAttribute("hidra", hRepo.findAll());
        return "list";
    }

    @Autowired
    private ElecService Eservice;
    @Autowired
    private HidraService Hservice;


    @RequestMapping("/search")
    public String search( Model model, String keyword) {
        if(keyword!=null) {
            List<MyElectriqueEntity> listE = Eservice.getByKeyword(keyword);
            model.addAttribute("electric", listE);
            List<MyHydrauliqueEntity> listH = Hservice.getByKeyword(keyword);
            model.addAttribute("hidra", listH);
        }else {
            List<MyElectriqueEntity> listE = Eservice.getAllShops();
            model.addAttribute("electric", listE);}
            List<MyHydrauliqueEntity> listH = Hservice.getByKeyword(keyword);
            model.addAttribute("hidra", listH);
        return "list";
    }

    @RequestMapping("/descriptionEl")
    public String descriptionEl(Model model, MyElectriqueEntity ent) {
        model.addAttribute("elec",ent);

        return "descriptionEl";
    }

    @RequestMapping("/descriptionHi")
    public String descriptionHi(Model model, MyHydrauliqueEntity ent) {
        model.addAttribute("hidr",ent);

        return "descriptionHi";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditClientForm(@PathVariable(name="id") Long id) {
        ModelAndView mav = new ModelAndView("editUser");

        MyClientEntity client = clientDAO.getById(id);
        selectedUser = client;
        mav.addObject("client", client);
        return mav;
    }

    @PostMapping("/process_edit")
    public String processEdit(MyClientEntity client){
        //client = client avec nouvelles info, mais incompletes
        //selecteduser = client avec anciennes info
        client.edit(selectedUser); //on met les infos manquantes dans user
        clientDAO.save(client);
        return "redirect:/admin";
    }

    @RequestMapping("/delete/{id}")
    public String deleteClient(@PathVariable(name="id") Long id) {
        clientDAO.delete(id);
        return "redirect:/admin";
    }

    @GetMapping("/403")
    public String error403()
    {
        return "403";
    }



}
