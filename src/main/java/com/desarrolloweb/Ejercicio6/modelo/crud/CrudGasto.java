package com.desarrolloweb.Ejercicio6.modelo.crud;

import org.springframework.data.repository.CrudRepository;

import com.desarrolloweb.Ejercicio6.modelo.entidades.Gasto;


public interface CrudGasto extends CrudRepository<Gasto, String> {
    
}