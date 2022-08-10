package com.desarrolloweb.Ejercicio6.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping("gasto/agregar")
    public String agregar(Model model) {
        model.addAttribute("gasto", new Gasto());
        model.addAttribute("usuario", ControladorUsuario.usuario);
        model.addAttribute("isAdmin", ControladorUsuario.rol);
        return "gasto/agregar";
    }

    @PostMapping("/gasto/agregar")
    public String agregarGasto(Gasto gasto, Model model) {
        gasto.setUsuario_id(ControladorUsuario.usuario.getCedula());
        gastoService.agregar(gasto);
        List<Gasto> gastos = gastoService.buscarPorCedula(ControladorUsuario.usuario.getCedula());
        model.addAttribute("usuario", ControladorUsuario.usuario);
        model.addAttribute("isAdmin", ControladorUsuario.rol);
        model.addAttribute("gastos", gastos);
        return "gasto/listar";
    }

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

    @PostMapping("/gasto/editar")
    public String gastoEditar(Gasto gasto, Model model) {
        gastoService.editar(gasto);
        List<Gasto> gastos = gastoService.buscarPorCedula(ControladorUsuario.usuario.getCedula());
        model.addAttribute("usuario", ControladorUsuario.usuario);
        model.addAttribute("isAdmin", ControladorUsuario.rol);
        model.addAttribute("gastos", gastos);
        return "gasto/listar";
    }

    @PostMapping("/gasto/eliminar")
    public String gastoEliminar(Gasto gasto, Model model) {
        System.out.println("ELIMINANDO------>"+gasto.getId());
        gastoService.eliminar(gasto.getId());
        List<Gasto> gastos = gastoService.buscarPorCedula(ControladorUsuario.usuario.getCedula());
        model.addAttribute("usuario", ControladorUsuario.usuario);
        model.addAttribute("isAdmin", ControladorUsuario.rol);
        model.addAttribute("gastos", gastos);
        return "gasto/listar";
    }

    @RequestMapping("/gasto/listarTodos")
    public String gastoListarTodos(Model model) {
        List<Gasto> gastos = gastoService.listar();
        model.addAttribute("usuario", ControladorUsuario.usuario);
        model.addAttribute("isAdmin", ControladorUsuario.rol);
        model.addAttribute("gastos", gastos);
        return "gasto/listar";
    }
}