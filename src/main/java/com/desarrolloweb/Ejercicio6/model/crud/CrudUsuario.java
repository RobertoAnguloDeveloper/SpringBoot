package com.desarrolloweb.Ejercicio6.model.crud;

import org.springframework.data.repository.CrudRepository;

import com.desarrolloweb.Ejercicio6.model.entidades.Usuario;

public interface CrudUsuario extends CrudRepository<Usuario, String> {
    
}