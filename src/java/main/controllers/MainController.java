/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.controllers;

import main.model.Ocena;
import java.util.List;
import javax.servlet.http.HttpSession;
import main.modelDAO.DB;
import main.model.Izvestaj;
import main.model.Predmet;
import main.model.Profesor;
import main.model.Ucenik;
import main.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Stenci
 */
@Controller
@RequestMapping("/")
@SessionAttributes("ucenik")
public class MainController {
    
    @Autowired
     MainService mainService;

    @RequestMapping("/home")
    public String home(HttpSession session) {
        if(session.getAttribute("ucenik")==null)
            return "neuspesno";
        return "home";
    }

    @RequestMapping("/aboutus")
    public String aboutus() {
        return "aboutus";
    }
    
    @RequestMapping("/zadatak")
    public String zadatak(ModelMap model) {
        List<Predmet> res = DB.query("SELECT p FROM Predmet p");
        model.addAttribute("predmeti", res);
        return "zadatak";
    }
    
    @RequestMapping("/logOut")
    public String logOut(HttpSession session) {
        session.invalidate();
        return "index";
    }  
    
    @RequestMapping("/logOut1")
    public String logOut1() {
        return "novastrana";
    } 

    @RequestMapping("/predmeti")
    public String predmeti(ModelMap model, HttpSession session) {
        
        List<Predmet> res = DB.query("SELECT p FROM Predmet p");
        model.addAttribute("predmeti", res);
        return "predmeti";
    }

    @RequestMapping("/nastavnikocene")
    public String nastavnikocene(ModelMap model, HttpSession session){
        
       if(session.getAttribute("profesor")==null)
           return "neuspesno";
         
        List<Ocena> res = mainService.getAllOcene();
        model.addAttribute("ocene", res);
        return "nastavnikocene";
    }

    @RequestMapping("/ucenikocene")
    public String ucenikocene(ModelMap model, HttpSession session){
        
       if(session.getAttribute("ucenik")==null)
           return "neuspesno";
        
        List<Ocena> res = mainService.getAllOcene();
        model.addAttribute("ocene", res);
        return "ucenikocene";
    }

    @RequestMapping("/nastavnikizvestaji")
    public String izvestaji(ModelMap model, HttpSession session) {

        if(session.getAttribute("profesor")==null)
            return "neuspesno";
        
        List<Izvestaj> res = DB.query("SELECT i FROM Izvestaj i");
        model.addAttribute("izvestaji", res);
        return "nastavnikizvestaji";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/logInUser")
    public String logInUser(
            ModelMap model,
            HttpSession session,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String pass) {

        if (username == null || pass == null) {
            return "logInUser";
        }
        List<Ucenik> res = DB.query("SELECT u FROM Ucenik u WHERE u.ucnUser=?1", username);
        if(res.isEmpty() || !pass.equals(res.get(0).getUcnPass()))
            return "neuspesno";
        session.setAttribute("ucenik", res.get(0));
        return "novastranauser";
    }

    @RequestMapping("/logInProfessor")
    public String logInProfessor(
            ModelMap model,
            HttpSession session,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String pass) {

        if (username == null || pass == null) {
            return "logInProfessor";
        }
        List<Profesor> res = DB.query("SELECT p FROM Profesor p WHERE p.proUser=?1", username);
        if(res.isEmpty() || !pass.equals(res.get(0).getProPass()))
            return "neuspesno";
        session.setAttribute("profesor", res.get(0));
        return "novastrana";
    }
    
    @RequestMapping("/novastrana")
    public String novastrana(HttpSession session) {
        if(session.getAttribute("profesor")==null)
            return "neuspesno";
        
        if(session.getAttribute("ucenik")==null)
            return "neuspesno";
        
        return "novastrana";
    }
    
    @RequestMapping("/unos")
    public String unos(
            ModelMap model, 
            HttpSession session
            ,@RequestParam("predmetId") String predmetId
            ,@RequestParam("ucenikId") String ucenikId
            ,@RequestParam("ocena") String ocena
           
            ) {
        mainService.insertNovaOcena(predmetId, ucenikId, ocena);
        
        model.addAttribute("predmetId", predmetId); 
        model.addAttribute("ucenikId", ucenikId); 
        model.addAttribute("ocena", ocena);    
        return "novastrana";          
    }
    
    @RequestMapping("/unosizvestaja")
    public String unosizvestaja(
            ModelMap model, 
            HttpSession session
            ,@RequestParam("profesorId") String profesorId
            ,@RequestParam("ucenikId") String ucenikId
            ,@RequestParam("izvestaj") String izvestaj
           
            ) {
        mainService.insertNoviIzvestaj(profesorId, ucenikId, izvestaj);
        
        model.addAttribute("profesorId", profesorId); 
        model.addAttribute("ucenikId", ucenikId); 
        model.addAttribute("izvestaj", izvestaj);    
        return "novastrana";          
    }
    
}


