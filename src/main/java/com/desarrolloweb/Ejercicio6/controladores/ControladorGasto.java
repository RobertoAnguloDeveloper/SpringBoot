package com.desarrolloweb.Ejercicio6.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.desarrolloweb.Ejercicio6.modelo.entidades.Gasto;
import com.desarrolloweb.Ejercicio6.modelo.entidades.Usuario;
import com.desarrolloweb.Ejercicio6.servicios.ServicioGasto;


@Controller
public class ControladorGasto {

    @Autowired
    private ServicioGasto gastoService;
    private Gasto gasto;
    private Usuario usuario;

    @RequestMapping("/gasto")
    public String gastoListar(Model model) {
        gasto = new Gasto();
        List<Gasto> gastos = gastoService.buscarPorCedula(ControladorUsuario.usuario.getCedula());
        model.addAttribute("usuario", ControladorUsuario.usuario);
        model.addAttribute("isAdmin", ControladorUsuario.rol);
        model.addAttribute("gastos", gastos);
        return "gasto/listar";
    }

    @RequestMapping("/gasto/buscar")
    public String gastoBuscarPagina(Model model) {
        gasto = new Gasto();
        model.addAttribute("usuario", ControladorUsuario.usuario);
        model.addAttribute("isAdmin", ControladorUsuario.rol);
        model.addAttribute("gasto", gasto);
        return "gasto/buscar";
    }


    @PostMapping("/gasto/buscar")
    public String gastoBuscar(Usuario usuario, Model model) {
        gasto = new Gasto();
        List<Gasto> gastos = gastoService.buscarPorCedula(usuario.getCedula());
        model.addAttribute("usuario", ControladorUsuario.usuario);
        model.addAttribute("isAdmin", ControladorUsuario.rol);
        model.addAttribute("gastosEncontrados", gastos);
        return "gasto/buscar";
    }

    // /*th:ref to gasto/index.html */
    // @GetMapping("/gasto/index")
    // public String index(Model model) {
    //     var gastos = gastoService.listar();
    //     model.addAttribute("gastos", gastos);
    //     return "gasto/index";
    // }

    // /*th:ref to gasto/agregar.html */
    // @PostMapping("/gasto/agregar")
    // public String agregar(Model model) {
    //     var gasto = new Gasto();
    //     model.addAttribute("gasto", gasto);
    //     return "gasto/agregar";
    // }

    // /*th:ref to usuario/buscar.html */
    // @GetMapping("/gasto/buscar")
    // public String buscar(Model model) {
    //     var gasto = new Gasto();
    //     model.addAttribute("gasto", gasto);
    //     return "gasto/buscar";
    // }

    // /*th:ref to gasto/editar.html */
    // @PostMapping("/gasto/editar")
    // public String editar(Model model) {
    //     var gasto = new Gasto();
    //     model.addAttribute("gasto", gasto);
    //     return "gasto/editar";
    // }

    // /*th:ref to gasto/eliminar.html */
    // @GetMapping("/gasto/eliminar")
    // public String eliminar(Model model) {
    //     var gasto = new Gasto();
    //     model.addAttribute("gasto", gasto);
    //     return "gasto/eliminar";
    // }

    // /*th:ref to gasto/listar.html */
    // @GetMapping("/gasto/listar")
    // public String listar(Model model) {
    //     var gastos = gastoService.listar();
    //     model.addAttribute("gastos", gastos);
    //     return "gasto/listar";
    // }

    
}