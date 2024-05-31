package com.systemupdate.beta.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Open home page
    @GetMapping({"/", "/home"})
    public String view() {
        return "home";
    }

    // Open login page
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // Login invalid
    @GetMapping("/login-error")
    public String loginError(ModelMap model) {
        model.addAttribute("alerta", "erro");
        model.addAttribute("titulo", "Credenciais inválidas");
        model.addAttribute("texto", "Login ou senha incorretos, tente novamente.");
        model.addAttribute("subtexto", "Acesso permitido apenas para cadastros já ativos.");

        return "login";
    }
}
