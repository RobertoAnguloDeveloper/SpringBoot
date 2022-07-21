package com.desarrolloweb.Ejercicio6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.desarrolloweb.Ejercicio6.model.crud.UsuariosDAO;

@Controller
public class ControllerInicio {
    @Autowired
    private UsuariosDAO usuariosDAO;

    @GetMapping("/")
    public String start(Model model) {
        var usuarios = usuariosDAO.findAll();
        model.addAttribute("usuarios", usuarios);
        return "index";
    }
}