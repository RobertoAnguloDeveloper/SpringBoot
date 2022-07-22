package com.desarrolloweb.Ejercicio6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.desarrolloweb.Ejercicio6.model.entidades.Usuario;
import com.desarrolloweb.Ejercicio6.model.servicios.ServicioUsuario;

@Controller
public class ControladorUsuario {

    @Autowired
    private ServicioUsuario usuarioService;

    @GetMapping("/")
    public String start(Model model) {
        var usuarios = usuarioService.listar();
        model.addAttribute("usuarios", usuarios);
        return "index";
    }

    /*th:ref to usuario/index.html */
    @GetMapping("/usuario/index")
    public String index(Model model) {
        var usuarios = usuarioService.listar();
        model.addAttribute("usuarios", usuarios);
        return "usuario/index";
    }

    /*th:ref to usuario/agregar.html */
    @GetMapping("/usuario/agregar")
    public String agregar(Model model) {
        var usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "usuario/agregar";
    }

    /*th:ref to usuario/editar.html */
    @GetMapping("/usuario/editar")
    public String editar(Model model) {
        var usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "usuario/editar";
    }

    /*th:ref to usuario/eliminar.html */
    @GetMapping("/usuario/eliminar")
    public String eliminar(Model model) {
        var usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "usuario/eliminar";
    }

    /*th:ref to usuario/listar.html */
    @GetMapping("/usuario/listar")
    public String listar(Model model) {
        var usuarios = usuarioService.listar();
        model.addAttribute("usuarios", usuarios);
        return "usuario/listar";
    }
}