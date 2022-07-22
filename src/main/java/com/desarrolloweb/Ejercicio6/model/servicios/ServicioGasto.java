package com.desarrolloweb.Ejercicio6.model.servicios;

import java.util.List;

import com.desarrolloweb.Ejercicio6.model.entidades.Gasto;

public interface ServicioGasto {
    public boolean agregar(Gasto gasto);
    public Gasto buscar(String id);
    public boolean editar(Gasto gasto);
    public boolean eliminar(String id);
    public List<Gasto> listar();
}
