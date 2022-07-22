package com.desarrolloweb.Ejercicio6.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desarrolloweb.Ejercicio6.modelo.entidades.Usuario;
import com.desarrolloweb.Ejercicio6.servicios.ServicioUsuario;

@RestController
@RequestMapping("/usuario")
public class ControladorUsuario {

    @Autowired
    private ServicioUsuario usuarioService;

    @GetMapping("/usuario")
    public String start(Model model) {
        var usuarios = usuarioService.listar();
        model.addAttribute("usuarios", usuarios);
        return "index";
    }

    /*th:ref to /datosEstudiante.html */
    @GetMapping("/datosEstudiante")
    public String datosEstudiante(Model model) {
        return "datosEstudiante";
    }

    /*th:ref to usuario/login.html */
    @GetMapping("/usuario/login")
    public String login(Model model) {
        var usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "/usuario/login";
    }

    @PostMapping("/login")
    public String login(Usuario usuario) {
        String cedula = usuario.getCedula();
        usuario = usuarioService.buscar(cedula);
        return "redirect:/usuario/logeado";
    }

    /*th:ref to usuario/iniciar_sesion.html */
    @PostMapping("/usuario/iniciar_sesion")
    public String iniciarSesion(Model model) {
        var usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "usuario/iniciar_sesion";
    }

    /*GetMapping th:ref to usuario/cerrar_sesion.html */
    @GetMapping("/usuario/cerrar_sesion")
    public String cerrarSesion(Model model) {
        var usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "usuario/cerrar_sesion";
    }

    /*PostMapping th:ref to usuario/recordar_pass.html */
    @PostMapping("/usuario/recordar_pass")
    public String recordarPass(Model model) {
        var usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "usuario/recordar_pass";
    }

    /*PostMapping th:ref to usuario/cambiar_pass.html */
    @PostMapping("/usuario/cambiar_pass")
    public String cambiarPass(Model model) {
        var usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "usuario/cambiar_pass";
    }

    /*th:ref to usuario/index.html */
    @GetMapping("/usuario/index")
    public String index(Model model) {
        var usuarios = usuarioService.listar();
        model.addAttribute("usuarios", usuarios);
        return "usuario/index";
    }

    /*th:ref to usuario/agregar.html */
    @PostMapping("/usuario/agregar")
    public String agregar(Model model) {
        var usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "usuario/agregar";
    }

    /*th:ref to usuario/buscar.html */
    @GetMapping("/usuario/buscar")
    public String buscar(Model model) {
        var usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "usuario/buscar";
    }

    /*th:ref to usuario/editar.html */
    @PostMapping("/usuario/editar")
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