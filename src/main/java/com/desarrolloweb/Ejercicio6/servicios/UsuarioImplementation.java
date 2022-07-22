package com.desarrolloweb.Ejercicio6.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desarrolloweb.Ejercicio6.modelo.crud.CrudUsuario;
import com.desarrolloweb.Ejercicio6.modelo.entidades.Usuario;

@Service
public class UsuarioImplementation implements ServicioUsuario{

    @Autowired
    private CrudUsuario usuarioDAO;

    @Override
    @Transactional
    public boolean agregar(Usuario usuario) {
        return usuarioDAO.save(usuario) != null;
    }

    @Override
    @Transactional
    public Usuario buscar(String id) {
        return usuarioDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public boolean editar(Usuario usuario) {
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
    public List<Usuario> listar() {
        usuarioDAO.findAll();
        return (List<Usuario>) usuarioDAO.findAll();
    }

}
