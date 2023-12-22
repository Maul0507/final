package com.bantanair.webapp.Controller;

import java.security.PublicKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bantanair.webapp.Model.Informasi;
import com.bantanair.webapp.Service.InformasiService;

@Controller
public class ControllerHome {

    @Autowired
    private InformasiService informasiService;
    @GetMapping("/")
    public String login() {
        return "Login";
    }

    @GetMapping("/home")
    public String home() {
        return "Home";
    }

    @GetMapping("/informasi")
    public String informasi(Model model) {
        model.addAttribute("informasi", informasiService.getAll());
        return "Informasi";
    }

    @GetMapping("/kelolainformasi")
    public String kelolainformasi(Informasi informasi) {
        Informasi informasi2 = new Informasi();
        return "KelolaInformasi";
    }

    @PostMapping("/kelolainformasi")
    public String saveInformasi(Informasi informasi, Model model){
        informasiService.createInformasi(informasi);
        model.addAttribute("informasi", informasi);
        return "redirect:/informasi";
    }

    @GetMapping("/logout")
    public String logout() {
        return "Logout";
    }

    @GetMapping("/profil")
    public String profil() {
        return "Profil";
    }



}