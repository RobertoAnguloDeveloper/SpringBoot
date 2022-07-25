package com.desarrolloweb.Ejercicio6.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.desarrolloweb.Ejercicio6.modelo.crud.CrudGasto;
import com.desarrolloweb.Ejercicio6.modelo.crud.CrudUsuario;
import com.desarrolloweb.Ejercicio6.modelo.entidades.Gasto;
import com.desarrolloweb.Ejercicio6.modelo.entidades.Usuario;

@Service
public class GastoImplementation implements ServicioGasto{

    @Autowired
    private CrudGasto gastoDAO;

    @Override
    @Transactional
    public boolean agregar(Gasto gasto) {
        return gastoDAO.save(gasto) != null;
    }

    @Override
    @Transactional
    public Gasto buscar(String id) {
        return gastoDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public List<Gasto> buscarPorCedula(String cedula){
        List<Gasto> gastos = (List<Gasto>)gastoDAO.findAll();
        List<Gasto> gastosFiltrados = new ArrayList<>();
        for(Gasto gasto : gastos){
            String cedulaUsuario = gasto.getUsuario_id();
            if(cedulaUsuario.equals(cedula)){
                gastosFiltrados.add(gasto);
            }
        }
        return gastosFiltrados;
    }

    @Override
    @Transactional
    public boolean editar(Gasto gasto) {
        if(gastoDAO.save(gasto) != null) {
            return true;
        }else {
            return false;
        }
    }

    @Override
    @Transactional
    public boolean eliminar(String id) {
        gastoDAO.deleteById(id);
        if(!gastoDAO.findById(id).isPresent()) {
            return true;
        }else {
            return false;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Gasto> listar() {
        gastoDAO.findAll();
        return (List<Gasto>) gastoDAO.findAll();
    }

}
