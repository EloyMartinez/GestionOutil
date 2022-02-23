package com.example.gestionoutil.controllers;

import org.springframework.web.bind.annotation.RequestParam;

import com.example.gestionoutil.dao.ClientDAO;
import com.example.gestionoutil.dao.ElectriqueDAO;
import com.example.gestionoutil.dao.HydrauliqueDAO;
import com.example.gestionoutil.entity.MyClientEntity;
import com.example.gestionoutil.entity.MyElectriqueEntity;
import com.example.gestionoutil.entity.MyHydrauliqueEntity;
import com.example.gestionoutil.repositories.ElectricRepository;
import com.example.gestionoutil.repositories.ClientRepository;
import com.example.gestionoutil.repositories.HydraulicRepository;
import com.example.gestionoutil.services.ElecService;
import com.example.gestionoutil.services.HydrauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Objects;

@Controller
public class AppController {

    /*@Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ElectricRepository eRepo;
    @Autowired
    private HydraulicRepository hRepo;
    @Autowired
    private ElecService eService;
    @Autowired
    private HydrauService hService;*/

    private ClientDAO clientDAO = new ClientDAO();
    private ElectriqueDAO electiqueDAO = new ElectriqueDAO();
    private HydrauliqueDAO hydrauliqueDAO = new HydrauliqueDAO();

    public static MyClientEntity selectedUser;
    public static MyElectriqueEntity selectedElectrique;
    public static MyHydrauliqueEntity selectedHydraulique;

    //GET MAPPING
    @GetMapping("")
    public String viewHomePage() {
        return "login";
    }

    @GetMapping("/admin_user")
    public String admin_user(Model model) {
        //List<MyClientEntity> listClient = clientRepository.findAll();
        List<MyClientEntity> listClient = clientDAO.getAll();
        model.addAttribute("listClients", listClient);
        return "admin_user";
    }

    @GetMapping("/admin_product")
    public String admin_product(Model model) {
        //model.addAttribute("hrepo", hRepo.findAll());
        //model.addAttribute("erepo", eRepo.findAll());
        model.addAttribute("hrepo", hydrauliqueDAO.getAll());
        model.addAttribute("erepo", electiqueDAO.getAll());
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

    @GetMapping("/list")
    public String list(Model model) {
        //model.addAttribute("electric", eRepo.findAll());
        //model.addAttribute("hydrau", hRepo.findAll());
        model.addAttribute("electric", electiqueDAO.getAll());
        model.addAttribute("hydrau", hydrauliqueDAO.getAll());
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

    MultipartFile imageFile;

    @RequestMapping(value = "/add_product_elec_success", method = RequestMethod.POST)
    public String add_product_elec_success(MyElectriqueEntity electrique,@RequestParam("file") MultipartFile file) throws IOException {
        //electiqueDAO = new ElectriqueDAO();
        electrique.setImage(file.getBytes());
        electiqueDAO.save(electrique);
        return "redirect:/admin_product";
    }

    @RequestMapping(value = "/add_product_hydrau_success", method = RequestMethod.POST)
    public String add_product_hydrau_success(MyHydrauliqueEntity hydraulique, @RequestParam("file") MultipartFile file) throws IOException {
        //hydrauliqueDAO = new HydrauliqueDAO();
        hydraulique.setImage(file.getBytes());
        hydrauliqueDAO.save(hydraulique);
        return "redirect:/admin_product";
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

    /*@Autowired
    private ElecService Eservice;
    @Autowired
    private HydrauService Hservice;*/

    @PostMapping("/process_edit_product_elec")
    public String processEditProductElec(MyElectriqueEntity electrique, @RequestParam("file") MultipartFile file) throws IOException {

        try {
            if(!file.isEmpty()) {
                electrique.setImage(file.getBytes());
            }
            //selectedElectrique.getImage();
            electrique.edit(selectedElectrique);
            electiqueDAO.save(electrique);
            return "redirect:/admin_product";
        } catch (Exception e){
            electrique.edit(selectedElectrique);
            electiqueDAO.save(electrique);
            return "redirect:/admin_product";
        }
    }

    @PostMapping("/process_edit_product_hydrau")
    public String processEditProductHydrau(MyHydrauliqueEntity hydraulique, @RequestParam("file") MultipartFile file) throws IOException {
        try {
            if(!file.isEmpty()) {
                hydraulique.setImage(file.getBytes());
            }
            hydraulique.edit(selectedHydraulique);
            hydrauliqueDAO.save(hydraulique);
            return "redirect:/admin_product";
        } catch (Exception e){
            hydraulique.edit(selectedHydraulique);
            hydrauliqueDAO.save(hydraulique);
            return "redirect:/admin_product";
        }
    }

    //REQUEST MAPPING
    @RequestMapping("/descriptionEl")
    public String descriptionEl(Model model, MyElectriqueEntity ent) {
        MyElectriqueEntity myElectriqueEntity = electiqueDAO.getById(ent.getIdelec());
        model.addAttribute("elec", myElectriqueEntity);
        return "descriptionEl";
    }

    @RequestMapping("/descriptionHy")
    public String descriptionHi(Model model, MyHydrauliqueEntity ent) {
        MyHydrauliqueEntity myHydrauliqueEntity= hydrauliqueDAO.getById(ent.getIdhyd());
        model.addAttribute("hydrau", myHydrauliqueEntity);
        return "descriptionHy";
    }

    @RequestMapping("/editUser/{id}")
    public ModelAndView showEditClientForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("editUser");
        MyClientEntity client = clientDAO.getById(id);
        selectedUser = client;
        mav.addObject("client", client);
        return mav;
    }

    @RequestMapping("/editProductElec/{id}")
    public ModelAndView showEditProductElecForm(@PathVariable(name="id") Long id) throws IOException {
        ModelAndView mav = new ModelAndView("editProductElec");
        MyElectriqueEntity electrique = electiqueDAO.getById(id);
        selectedElectrique = electrique;
        mav.addObject("editProductElec", electrique);
        return mav;
    }

    @RequestMapping("/editProductHydrau/{id}")
    public ModelAndView showEditProductHydrauForm(@PathVariable(name="id") Long id) throws IOException {
        ModelAndView mav = new ModelAndView("editProduitHydrau");
        MyHydrauliqueEntity hydraulique = hydrauliqueDAO.getById(id);
        //hydraulique.setImage(imageFile.getBytes());
        selectedHydraulique = hydraulique;
        mav.addObject("editProductHydrau", hydraulique);
        return mav;
    }

    @RequestMapping("/deleteUser/{id}")
    public String deleteClient(@PathVariable(name = "id") Long id) {
        clientDAO.delete(id);
        return "redirect:/admin_user";
    }

    @RequestMapping("/deleteProductElec/{id}")
    public String deleteProductElec(@PathVariable(name = "id") Long id) {
        electiqueDAO.delete(id);
        return "redirect:/admin_product";
    }

    @RequestMapping("/deleteProductHydrau/{id}")
    public String deleteProductHydrau(@PathVariable(name = "id") Long id) {
        hydrauliqueDAO.delete(id);
        return "redirect:/admin_product";
    }

    @GetMapping("/index")
    public String index(Model model) {
        //model.addAttribute("electric", eRepo.findAll());
        //model.addAttribute("hydraulic", hRepo.findAll());
        model.addAttribute("electric", electiqueDAO.getAll());
        model.addAttribute("hydraulic", hydrauliqueDAO.getAll());
        return "index";
    }

    @RequestMapping("/addProductHydrau")
    public String addProductHydrau(Model model) {
        model.addAttribute("hydrau", new MyHydrauliqueEntity());
        return "addProductHydrau";
    }

    @RequestMapping("/addProductElec")
    public String addProductElec(Model model) {
        model.addAttribute("elec", new MyElectriqueEntity());
        return "addProductElec";
    }

    @RequestMapping("/addUser")
    public String addUser(Model model) {
        model.addAttribute("client", new MyClientEntity());
        return "addUser";
    }

    @RequestMapping("/search")
    public String showToolOfType(Model model, String toolType, String keyword) { //TODO: envoyer une erreur si pas d'objet dans la catégorie
        //TODO: outils manuels à rejouter
        if (!Objects.equals(keyword, "")) {
            if (Objects.equals(toolType, "electric")) {
                //List<MyElectriqueEntity> listE = eService.getByKeyword(keyword);
                List<MyElectriqueEntity> listE = electiqueDAO.getByKeyword(keyword);
                model.addAttribute("electric", listE);
            } else if (Objects.equals(toolType, "hydraulic")) {
                //List<MyHydrauliqueEntity> listH = hService.getByKeyword(keyword);
                List<MyHydrauliqueEntity> listH = hydrauliqueDAO.getByKeyword(keyword);
                model.addAttribute("hydraulic", listH);
            } else {
                //List<MyElectriqueEntity> listE = eService.getByKeyword(keyword);
                List<MyElectriqueEntity> listE = electiqueDAO.getByKeyword(keyword);
                model.addAttribute("electric", listE);
                //List<MyHydrauliqueEntity> listH = hService.getByKeyword(keyword);
                List<MyHydrauliqueEntity> listH = hydrauliqueDAO.getByKeyword(keyword);
                model.addAttribute("hydraulic", listH);
            }
        } else {
            if (Objects.equals(toolType, "electric")) {
                //List<MyElectriqueEntity> listE = eService.getAll();
                List<MyElectriqueEntity> listE = electiqueDAO.getAll();
                model.addAttribute("electric", listE);
            } else if (Objects.equals(toolType, "hydraulic")) {
                //List<MyHydrauliqueEntity> listH = hService.getAll();
                List<MyHydrauliqueEntity> listH = hydrauliqueDAO.getAll();
                model.addAttribute("hydraulic", listH);
            } else {
                //List<MyElectriqueEntity> listE = eService.getAll();
                List<MyElectriqueEntity> listE = electiqueDAO.getAll();
                model.addAttribute("electric", listE);
                //List<MyHydrauliqueEntity> listH = hService.getAll();
                List<MyHydrauliqueEntity> listH = hydrauliqueDAO.getAll();
                model.addAttribute("hydraulic", listH);
            }
        }
        return "index";
    }
}
