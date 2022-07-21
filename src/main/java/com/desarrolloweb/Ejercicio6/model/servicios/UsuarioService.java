package com.desarrolloweb.Ejercicio6.model.servicios;

import java.util.List;

import com.desarrolloweb.Ejercicio6.model.entidades.Usuarios;

public interface UsuarioService {
    public boolean agregar(Usuarios usuario);
    public Usuarios buscar(String id);
    public boolean editar(Usuarios usuario);
    public boolean eliminar(String id);
    public List<Usuarios> listar();
}
