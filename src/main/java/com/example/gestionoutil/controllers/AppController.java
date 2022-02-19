package com.example.gestionoutil.controllers;

import com.example.gestionoutil.dao.ClientDAO;
import com.example.gestionoutil.dao.ElectriqueDAO;
import com.example.gestionoutil.entity.MyClientEntity;
import com.example.gestionoutil.entity.MyElectriqueEntity;
import com.example.gestionoutil.entity.MyHydrauliqueEntity;
import com.example.gestionoutil.repositories.ElectricRepository;
import com.example.gestionoutil.repositories.ClientRepository;
import com.example.gestionoutil.repositories.HydraulicRepository;
import com.example.gestionoutil.repositories.ManualRepository;
import com.example.gestionoutil.services.ElecService;
import com.example.gestionoutil.services.HidraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;

@Controller
public class AppController {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ElectricRepository eRepo;
    @Autowired
    private HydraulicRepository hRepo;
    @Autowired
    private ElecService eService;
    @Autowired
    private HidraService hService;

    private ClientDAO clientDAO = new ClientDAO();
    private ElectriqueDAO electiqueDAO = new ElectriqueDAO();

    public static MyClientEntity selectedUser;
    public static MyElectriqueEntity selectedElectrique;

    //GET MAPPING
    @GetMapping("")
    public String viewHomePage() {
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
        model.addAttribute("hrepo", hRepo.findAll());
        model.addAttribute("erepo", eRepo.findAll());
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

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("electric", eRepo.findAll());
        model.addAttribute("hidra", hRepo.findAll());
        return "list";
    }

    @GetMapping("/403")
    public String error403() {
        return "403";
    }

    //POST MAPPING
    @PostMapping("/process_register")
    public String processRegister(MyClientEntity client) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        client.setMdpcli(passwordEncoder.encode(client.getMdpcli()));
        client.setAdmin(false);
        clientDAO = new ClientDAO();
        clientDAO.save(client);
        return "register_success";
    }

    //POST MAPPING
    @RequestMapping(value = "/add_success", method = RequestMethod.POST)
    public String addSucces(MyClientEntity client, @RequestParam(value = "adminCheckbox", required = false) String checkboxValue) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        client.setMdpcli(passwordEncoder.encode(client.getMdpcli()));
        if (checkboxValue != null)
            client.setAdmin(true);
        else
            client.setAdmin(false);
        clientDAO = new ClientDAO();
        clientDAO.save(client);
        return "redirect:/admin_user";
    }

    @RequestMapping(value = "/process_edit_user", method = RequestMethod.POST)
    public String processEditUser(MyClientEntity client, @RequestParam(value = "adminCheckbox", required = false) String checkboxValue) {
        //client = client avec nouvelles info, mais incompletes
        //selecteduser = client avec anciennes info
        if (checkboxValue != null)
            client.setAdmin(true);
        else
            client.setAdmin(false);
        client.edit(selectedUser); //on met les infos manquantes dans user
        clientDAO.save(client);
        return "redirect:/admin_user";
    }

    @PostMapping("/process_edit_product")
    public String processEditProduct(MyElectriqueEntity electrique) {
        electrique.edit(selectedElectrique);
        electiqueDAO.save(electrique);
        return "redirect:/admin_product";
    }

    //REQUEST MAPPING
    @RequestMapping("/descriptionEl")
    public String descriptionEl(Model model, MyElectriqueEntity ent) {
        model.addAttribute("elec", ent);
        return "descriptionEl";
    }

    @RequestMapping("/descriptionHi")
    public String descriptionHi(Model model, MyHydrauliqueEntity ent) {
        model.addAttribute("hidr", ent);
        return "descriptionHi";
    }

    @RequestMapping("/editUser/{id}")
    public ModelAndView showEditClientForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("editUser");
        MyClientEntity client = clientDAO.getById(id);
        selectedUser = client;
        mav.addObject("client", client);
        return mav;
    }

    @RequestMapping("/editProduct/{id}")
    public ModelAndView showEditProductForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("editProduct");
        MyElectriqueEntity electrique = electiqueDAO.getById(id);
        selectedElectrique = electrique;
        mav.addObject("electrique", electrique);
        return mav;
    }

    @RequestMapping("/deleteUser/{id}")
    public String deleteClient(@PathVariable(name = "id") Long id) {
        clientDAO.delete(id);
        return "redirect:/admin_user";
    }

    @RequestMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id) {
        electiqueDAO.delete(id);
        return "redirect:/admin_product";
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("electric", eRepo.findAll());
        model.addAttribute("hydraulic", hRepo.findAll());
        return "index";
    }

    //Todo
    @RequestMapping("/addProduct")
    public String addProduct() {
        return "addProduct";
    }

    @RequestMapping("/addUser")
    public String addUser(Model model) {
        model.addAttribute("client", new MyClientEntity());
        return "addUser";
    }

    @RequestMapping("/search")
    public String showToolOfType(Model model, String toolType, String keyword) { //TODO: envoyer une erreur si pas d'objet dans la catégorie
        //TODO: outils manuels à rejouter
        if (keyword != "") {
            if (Objects.equals(toolType, "electric")) {
                List<MyElectriqueEntity> listE = eService.getByKeyword(keyword);
                model.addAttribute("electric", listE);
            } else if (Objects.equals(toolType, "hydraulic")) {
                List<MyHydrauliqueEntity> listH = hService.getByKeyword(keyword);
                model.addAttribute("hydraulic", listH);
            } else {
                List<MyElectriqueEntity> listE = eService.getByKeyword(keyword);
                model.addAttribute("electric", listE);
                List<MyHydrauliqueEntity> listH = hService.getByKeyword(keyword);
                model.addAttribute("hydraulic", listH);
            }
        } else {
            if (Objects.equals(toolType, "electric")) {
                List<MyElectriqueEntity> listE = eService.getAll();
                model.addAttribute("electric", listE);
            } else if (Objects.equals(toolType, "hydraulic")) {
                List<MyHydrauliqueEntity> listH = hService.getAll();
                model.addAttribute("hydraulic", listH);
            } else {
                List<MyElectriqueEntity> listE = eService.getAll();
                model.addAttribute("electric", listE);
                List<MyHydrauliqueEntity> listH = hService.getAll();
                model.addAttribute("hydraulic", listH);
            }
        }
        return "index";
    }
}
