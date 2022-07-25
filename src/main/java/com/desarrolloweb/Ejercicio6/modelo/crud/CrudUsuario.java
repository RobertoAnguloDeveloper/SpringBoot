package com.desarrolloweb.Ejercicio6.modelo.crud;

import org.springframework.data.repository.CrudRepository;

import com.desarrolloweb.Ejercicio6.modelo.entidades.Usuario;

public interface CrudUsuario extends CrudRepository<Usuario, String> {
    
    
}