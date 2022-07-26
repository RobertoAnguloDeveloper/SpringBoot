package com.desarrolloweb.Ejercicio6.servicios;

import java.util.List;

import com.desarrolloweb.Ejercicio6.modelo.entidades.Gasto;

public interface ServicioGasto {
    public boolean agregar(Gasto gasto);
    public Gasto buscar(String id);
    public List<Gasto> buscarPorCedula(String cedula);
    public boolean editar(Gasto gasto);
    public boolean eliminar(Long id);
    public List<Gasto> listar();
}
