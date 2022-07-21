package com.desarrolloweb.Ejercicio6.model.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desarrolloweb.Ejercicio6.model.crud.UsuariosDAO;
import com.desarrolloweb.Ejercicio6.model.entidades.Usuarios;

@Service
public class UsuarioImplementation implements UsuarioService{

    @Autowired
    private UsuariosDAO usuarioDAO;

    @Override
    @Transactional
    public boolean agregar(Usuarios usuario) {
        return usuarioDAO.save(usuario) != null;
    }

    @Override
    @Transactional
    public Usuarios buscar(String id) {
        return usuarioDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public boolean editar(Usuarios usuario) {
        if(usuarioDAO.save(usuario) != null) {
            return true;
        }else {
            return false;
        }
    }

    @Override
    @Transactional
    public boolean eliminar(String id) {
        usuarioDAO.deleteById(id);
        if(!usuarioDAO.findById(id).isPresent()) {
            return true;
        }else {
            return false;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuarios> listar() {
        usuarioDAO.findAll();
        return (List<Usuarios>) usuarioDAO.findAll();
    }

}
