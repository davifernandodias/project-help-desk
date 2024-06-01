package com.systemupdate.beta.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.systemupdate.beta.security.CustomUserDetails;

@Controller
public class HomeController {

    
    @GetMapping({"/", "/home"})
    public String view(ModelMap model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = auth.getName(); 
        boolean isAuthenticated = auth.isAuthenticated() && !(auth instanceof AnonymousAuthenticationToken);
        /*
         * MODAL DE AUTENTICAÇÃO E FILTRAGEM DE PERFIL DE ADMIN OU COLABORADOR.
         * 
         */
        
        model.addAttribute("isAuthenticated", isAuthenticated);
        model.addAttribute("userEmail", userEmail); 

        // Captura o cargo do usuário
        if (isAuthenticated && auth.getPrincipal() instanceof CustomUserDetails) {
            CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
            String role = userDetails.getRole();
            model.addAttribute("isAdmin", "ADMIN".equals(role)); 
        } else {
            model.addAttribute("isAdmin", false); 
        }

        return "home";
    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/login-error")
    public String loginError(ModelMap model) {
        model.addAttribute("alerta", "erro");
        model.addAttribute("titulo", "Credenciais inválidas");
        model.addAttribute("texto", "Login ou senha incorretos, tente novamente.");
        model.addAttribute("subtexto", "Acesso permitido apenas para cadastros já ativos.");

        return "login";
    }
}
