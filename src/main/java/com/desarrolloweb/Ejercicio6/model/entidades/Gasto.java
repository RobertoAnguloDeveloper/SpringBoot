package com.desarrolloweb.Ejercicio6.model.entidades;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "gastos")
public class Gasto implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String usuario_id;
    private String fecha;
    private String valor_total_sin_iva;
    private String iva_total;
    private String valor_total_con_iva;
    private String nombre_gasto;
    private String lugar;
    private String descripcion;
}