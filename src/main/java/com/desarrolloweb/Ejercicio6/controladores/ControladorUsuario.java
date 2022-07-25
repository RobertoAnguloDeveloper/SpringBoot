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
    private String rol;

    @GetMapping("/")
    public String index() {
        return "/";
    }

    @RequestMapping("/usuario")
    public String recargaIndexUsuario(Model model) {
        model.addAttribute("usuario", usuario);
        model.addAttribute("isAdmin", this.rol);
        return "/usuario/index";
    }

    @PostMapping("/login")
    public String login(Usuario usuario, Model model) {
            String cedula = usuario.getCedula();
            Usuario usuarioEncontrado = usuarioService.buscar(cedula);
            
            switch(usuarioService.verificarRol(usuario)){
                case "admin":
                    this.usuario = usuarioEncontrado;
                    this.rol = "true";
                    model.addAttribute("usuario", usuarioEncontrado);
                    model.addAttribute("isAdmin", "true");
                    return "/usuario/index";
                case "usuario":
                    this.usuario = usuarioEncontrado;
                    this.rol = "false";
                    model.addAttribute("usuario", usuarioEncontrado);
                    model.addAttribute("isAdmin", "false");
                    return "/usuario/index";
                case "error":
                    return "error";
                default:
                    return "redirect:/";
            }
    }

    /*th:ref to usuario/agregar.html */
    @GetMapping("/usuario/agregar")
    public String agregarForm() {
        return "usuario/agregar";
    }

    /*th:ref to usuario/agregar.html */
    @PostMapping("/usuario/agregar")
    public String agregar(Usuario usuario, Model model) {
        this.usuario = usuario;
        usuarioService.agregar(usuario);
        if(usuarioService.verificarRol(usuario) == "admin"){
            this.rol = "true";
        }else{
            this.rol = "false";
        }
        model.addAttribute("usuario", this.usuario);
        model.addAttribute("isAdmin", this.rol);
        return "/usuario/index";
    }

    @RequestMapping("/cuenta")
    public String cuenta(Model model) {
        model.addAttribute("usuario", this.usuario);
        model.addAttribute("isAdmin", this.rol);
        return "/usuario/editar";
    }

    @PostMapping("/cuenta")
    public String editarCuenta(Usuario usuario, Model model) {
        usuario.setCedula(this.usuario.getCedula());
        this.usuario = usuario;
        this.usuarioService.editar(usuario);
        model.addAttribute("usuario", this.usuario);
        model.addAttribute("isAdmin", this.rol);
        return "/usuario/index";
    }

    @PostMapping("/editar")
    public String editarCuentas(Usuario usuario, Model model) {
        
        Usuario usuarioAEditar = this.usuarioService.buscar(usuario.getCedula());

        usuarioAEditar.setClave(usuario.getClave());
        usuarioAEditar.setNombre(usuario.getNombre());
        usuarioAEditar.setTelefono(usuario.getTelefono());
        usuarioAEditar.setEmail(usuario.getEmail());

        this.usuarioService.editar(usuarioAEditar);

        model.addAttribute("usuario", this.usuario);
        model.addAttribute("isAdmin", this.rol);

        return "/usuario/index";
    }

    @PostMapping("/eliminar")
    public String eliminarCuenta(Usuario usuario, Model model) {
        this.usuarioService.eliminar(usuario.getCedula());
        model.addAttribute("usuario", this.usuario);
        model.addAttribute("isAdmin", this.rol);
        return "/usuario/index";
    }

    @RequestMapping("/listarCuentas")
    public String listarCuentas(Model model) {
        model.addAttribute("usuario", this.usuario);
        model.addAttribute("isAdmin", this.rol);
        model.addAttribute("usuarios", this.usuarioService.listar());
        return "/usuario/listar";
    }

    @RequestMapping("/buscar")
    public String buscar(Usuario usuario, Model model) {
        model.addAttribute("usuario", this.usuario);
        model.addAttribute("isAdmin", this.rol);
        model.addAttribute("usuarios", this.usuarioService.listar());
        // model.addAttribute("usuarioBuscado", this.usuarioService.buscar(usuario.getCedula()));
        return "/usuario/buscar";
    }

    @PostMapping("/buscar")
    public String buscarCuenta(Usuario usuario, Model model) {
        model.addAttribute("usuario", this.usuario);
        model.addAttribute("isAdmin", this.rol);
        model.addAttribute("usuarioBuscado", this.usuarioService.buscar(usuario.getCedula()));
        return "/usuario/buscar";
    }




    // /*th:ref to /datosEstudiante.html */
    // @GetMapping("/datosEstudiante")
    // public String datosEstudiante(Model model) {
    //     return "datosEstudiante";
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