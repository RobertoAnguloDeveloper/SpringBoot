package com.desarrolloweb.Ejercicio6.servicios;

import java.util.List;

import com.desarrolloweb.Ejercicio6.modelo.entidades.Usuario;

public interface ServicioUsuario {
    public boolean agregar(Usuario usuario);
    public Usuario buscar(String id);
    public boolean verificarUsuario(Usuario usuario);
    public String verificarRol(Usuario usuario);
    public boolean editar(Usuario usuario);
    public boolean eliminar(String id);
    public List<Usuario> listar();
}
