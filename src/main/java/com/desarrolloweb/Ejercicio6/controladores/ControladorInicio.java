package com.desarrolloweb.Ejercicio6.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/usuario")
    public String login(Model model) {
        return "/usuario/index";
    }

    /*th:ref to usuario/agregar.html */
    @GetMapping("/usuario/agregar")
    public String agregar(Model model) {
        var usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "/usuario/agregar";
    }

    /*th:ref to usuario/agregar.html */
    @PostMapping("/agregar")
    public String agregar(Usuario usuario) {
        usuarioService.agregar(usuario);
        return "redirect:/";
    }
}
