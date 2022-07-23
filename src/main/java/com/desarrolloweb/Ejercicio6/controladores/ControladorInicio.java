package com.desarrolloweb.Ejercicio6.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.desarrolloweb.Ejercicio6.modelo.entidades.Usuario;
import com.desarrolloweb.Ejercicio6.servicios.ServicioUsuario;

@Controller
public class ControladorInicio {
    @Autowired
    private ServicioUsuario usuarioService;

    @GetMapping("/")
    public String inicio(Model model) {
        return "index";
    }

    @RequestMapping("/usuario/")
    public String login(Model model) {
        /*Send request to ControladorUsuario*/
        return "/usuario/index";
    }

    // @GetMapping("/usuario/agregar")
    // public String agregar(Model model) {
    //     return "/usuario/agregar";
    // }
}
