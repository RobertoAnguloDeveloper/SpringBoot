package com.desarrolloweb.Ejercicio6.model.crud;

import org.springframework.data.repository.CrudRepository;

import com.desarrolloweb.Ejercicio6.model.entidades.Usuarios;

public interface UsuariosDAO extends CrudRepository<Usuarios, String> {
    
}