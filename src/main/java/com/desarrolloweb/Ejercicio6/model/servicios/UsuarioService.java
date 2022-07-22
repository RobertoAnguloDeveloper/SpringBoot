package com.desarrolloweb.Ejercicio6.model.servicios;

import java.util.List;

import com.desarrolloweb.Ejercicio6.model.entidades.Usuario;

public interface UsuarioService {
    public boolean agregar(Usuario usuario);
    public Usuario buscar(String id);
    public boolean editar(Usuario usuario);
    public boolean eliminar(String id);
    public List<Usuario> listar();
}
