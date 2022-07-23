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

public class ControladorUsuario {

    @Autowired
    private ServicioUsuario usuarioService;
    private Usuario usuario;

    @RequestMapping("/")
    public String index() {
        return "/";
    }

    @GetMapping("/usuario/")
    public String recargaIndexUsuario(Model model) {
        model.addAttribute("usuario", usuario);
        return "usuario/index";
    }

    @PostMapping("/login")
    public String login(Usuario usuario, Model model) {
        
        String cedula = usuario.getCedula();
        String clave = usuario.getClave();

        Usuario usuarioEncontrado = usuarioService.buscar(cedula);

        if (usuarioEncontrado != null && usuarioEncontrado.getClave().equals(clave)) {
            model.addAttribute("usuario", usuarioEncontrado);
            this.usuario = usuarioEncontrado;
            return "/usuario/index";
        } else {
            model.addAttribute("error", "Usuario no encontrado");
            return "redirect:/";
        }
    }

    // /*th:ref to /datosEstudiante.html */
    // @GetMapping("/datosEstudiante")
    // public String datosEstudiante(Model model) {
    //     return "datosEstudiante";
    // }

    // /*th:ref to usuario/login.html */
    // @GetMapping("/usuario/login")
    // public String login(Model model) {
    //     var usuario = new Usuario();
    //     model.addAttribute("usuario", usuario);
    //     return "/usuario/login";
    // }

    

    // /*th:ref to usuario/iniciar_sesion.html */
    // @PostMapping("/usuario/iniciar_sesion")
    // public String iniciarSesion(Model model) {
    //     var usuario = new Usuario();
    //     model.addAttribute("usuario", usuario);
    //     return "usuario/iniciar_sesion";
    // }

    // /*GetMapping th:ref to usuario/cerrar_sesion.html */
    // @GetMapping("/usuario/cerrar_sesion")
    // public String cerrarSesion(Model model) {
    //     var usuario = new Usuario();
    //     model.addAttribute("usuario", usuario);
    //     return "usuario/cerrar_sesion";
    // }

    // /*PostMapping th:ref to usuario/recordar_pass.html */
    // @PostMapping("/usuario/recordar_pass")
    // public String recordarPass(Model model) {
    //     var usuario = new Usuario();
    //     model.addAttribute("usuario", usuario);
    //     return "usuario/recordar_pass";
    // }

    // /*PostMapping th:ref to usuario/cambiar_pass.html */
    // @PostMapping("/usuario/cambiar_pass")
    // public String cambiarPass(Model model) {
    //     var usuario = new Usuario();
    //     model.addAttribute("usuario", usuario);
    //     return "usuario/cambiar_pass";
    // }

    // /*th:ref to usuario/index.html */
    // @GetMapping("/usuario/index")
    // public String index(Model model) {
    //     var usuarios = usuarioService.listar();
    //     model.addAttribute("usuarios", usuarios);
    //     return "usuario/index";
    // }

    /*th:ref to usuario/agregar.html */
    @GetMapping("usuario/agregar")
    public String agregarForm(Model model) {
        var usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "usuario/agregar";
    }

    /*th:ref to usuario/agregar.html */
    @PostMapping("/agregar")
    public String agregar(Usuario usuario) {
        usuarioService.agregar(usuario);
        return "usuario/agregar";
    }

    // /*th:ref to usuario/buscar.html */
    // @GetMapping("/usuario/buscar")
    // public String buscar(Model model) {
    //     var usuario = new Usuario();
    //     model.addAttribute("usuario", usuario);
    //     return "usuario/buscar";
    // }

    // /*th:ref to usuario/editar.html */
    // @PostMapping("/usuario/editar")
    // public String editar(Model model) {
    //     var usuario = new Usuario();
    //     model.addAttribute("usuario", usuario);
    //     return "usuario/editar";
    // }

    // /*th:ref to usuario/eliminar.html */
    // @GetMapping("/usuario/eliminar")
    // public String eliminar(Model model) {
    //     var usuario = new Usuario();
    //     model.addAttribute("usuario", usuario);
    //     return "usuario/eliminar";
    // }

    // /*th:ref to usuario/listar.html */
    // @GetMapping("/usuario/listar")
    // public String listar(Model model) {
    //     var usuarios = usuarioService.listar();
    //     model.addAttribute("usuarios", usuarios);
    //     return "usuario/listar";
    // }
}