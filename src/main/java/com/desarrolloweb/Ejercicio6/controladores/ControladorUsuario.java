package com.desarrolloweb.Ejercicio6.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.desarrolloweb.Ejercicio6.modelo.entidades.Usuario;
import com.desarrolloweb.Ejercicio6.servicios.ServicioEmail;
import com.desarrolloweb.Ejercicio6.servicios.ServicioUsuario;

@Controller
public class ControladorUsuario {

    @Autowired
    private ServicioUsuario usuarioService;
    public static Usuario usuario;
    public static String rol;

    @Autowired
	private ServicioEmail servicioEmail;

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

    @GetMapping("/usuario/agregar")
    public String agregarForm() {
        return "usuario/agregar";
    }

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
    public String buscar(Model model) {
        model.addAttribute("usuario", this.usuario);
        model.addAttribute("isAdmin", this.rol);
        model.addAttribute("usuarios", this.usuarioService.listar());
        return "/usuario/buscar";
    }

    @PostMapping("/buscar")
    public String buscarCuenta(Usuario usuario, Model model) {
        model.addAttribute("usuario", this.usuario);
        model.addAttribute("isAdmin", this.rol);
        Usuario usuarioBuscado = this.usuarioService.buscar(usuario.getCedula());
        if(usuarioBuscado != null){
            model.addAttribute("usuarioBuscado", usuarioBuscado);
            return "/usuario/buscar";
        }else{
            model.addAttribute("usuarioBuscado", null);
            return "/usuario/buscar";
        }
    }

    @RequestMapping("/recoverypass")
    public String recoverypass(Model model) {
        return "/usuario/recoverypass";
    }

    @PostMapping("/recoverypass")
    public String recoverypass(Usuario usuario, Model model) {
        Usuario usuarioBuscado = this.usuarioService.buscar(usuario.getCedula());
        if(usuarioBuscado != null){
            String clave = usuarioBuscado.getClave();
            String email = usuarioBuscado.getEmail();
            String mailEncoded = email.substring(0, email.length()/2)+"*".repeat(email.length()/2);
            String asunto = "Recuperación de contraseña";
            String mensaje = "Su contraseña es: " + clave;

            servicioEmail.enviarEmail(email, asunto, mensaje);
            model.addAttribute("usuarioBuscado", usuarioBuscado);
            model.addAttribute("mail", mailEncoded);
            return "/usuario/recoverypass";
        }else{
            model.addAttribute("noExiste", 1);
            return "/usuario/recoverypass";
        }
    }

    @RequestMapping("/logout")
    public String logout(Model model) {
        this.usuario = null;
        this.rol = null;
        return "redirect:/";
    }
}