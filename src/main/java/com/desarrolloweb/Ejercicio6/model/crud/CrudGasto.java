package com.desarrolloweb.Ejercicio6.model.crud;

import org.springframework.data.repository.CrudRepository;

import com.desarrolloweb.Ejercicio6.model.entidades.Gasto;


public interface CrudGasto extends CrudRepository<Gasto, String> {
    
}