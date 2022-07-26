package com.desarrolloweb.Ejercicio6.modelo.entidades;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cedula;
    private String clave;
    private String nombre;
    private String telefono;
    @Column(unique = true)
    private String email;
}