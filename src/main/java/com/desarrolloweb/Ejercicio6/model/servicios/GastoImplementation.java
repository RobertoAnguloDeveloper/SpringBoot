package com.desarrolloweb.Ejercicio6.model.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desarrolloweb.Ejercicio6.model.crud.CrudGasto;
import com.desarrolloweb.Ejercicio6.model.entidades.Gasto;

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
