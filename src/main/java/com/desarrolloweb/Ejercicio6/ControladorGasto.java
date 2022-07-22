package com.desarrolloweb.Ejercicio6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.desarrolloweb.Ejercicio6.model.entidades.Gasto;
import com.desarrolloweb.Ejercicio6.model.servicios.ServicioGasto;

@Controller
public class ControladorGasto {

    @Autowired
    private ServicioGasto gastoService;

    @GetMapping("/")
    public String start(Model model) {
        var gastos = gastoService.listar();
        model.addAttribute("gastos", gastos);
        return "index";
    }

    /*th:ref to gasto/index.html */
    @GetMapping("/gasto/index")
    public String index(Model model) {
        var gastos = gastoService.listar();
        model.addAttribute("gastos", gastos);
        return "usuario/index";
    }

    /*th:ref to gasto/agregar.html */
    @PostMapping("/gasto/agregar")
    public String agregar(Model model) {
        var gasto = new Gasto();
        model.addAttribute("gasto", gasto);
        return "gasto/agregar";
    }

    /*th:ref to usuario/buscar.html */
    @GetMapping("/gasto/buscar")
    public String buscar(Model model) {
        var gasto = new Gasto();
        model.addAttribute("gasto", gasto);
        return "gasto/buscar";
    }

    /*th:ref to gasto/editar.html */
    @PostMapping("/gasto/editar")
    public String editar(Model model) {
        var gasto = new Gasto();
        model.addAttribute("gasto", gasto);
        return "gasto/editar";
    }

    /*th:ref to gasto/eliminar.html */
    @GetMapping("/gasto/eliminar")
    public String eliminar(Model model) {
        var gasto = new Gasto();
        model.addAttribute("gasto", gasto);
        return "gasto/eliminar";
    }

    /*th:ref to gasto/listar.html */
    @GetMapping("/gasto/listar")
    public String listar(Model model) {
        var gastos = gastoService.listar();
        model.addAttribute("gastos", gastos);
        return "gasto/listar";
    }

    
}