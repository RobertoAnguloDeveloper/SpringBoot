package com.desarrolloweb.Ejercicio6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.desarrolloweb.Ejercicio6.model.servicios.UsuarioService;

@Controller
public class ControllerInicio {

    @Autowired
    private UsuarioService usuario;

    @GetMapping("/")
    public String start(Model model) {
        var usuarios = usuario.listar();
        model.addAttribute("usuarios", usuarios);
        return "index";
    }
}