/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.investigacion.operaciones.Services;

import com.investigacion.operaciones.Models.UsuarioModelo;
import com.investigacion.operaciones.Repositorys.UsuarioRepository;
import com.investigacion.operaciones.dto.request.LoginDto;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author oscar
 */
@Service
@Transactional
public class UsuariosServices {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Optional<UsuarioModelo> login(LoginDto dto) {
        return this.usuarioRepository.findByUsernameAndPassword(dto.getUsuario(), dto.getPassword());
    }

    @Transactional(readOnly = false)
    public UsuarioModelo crearUsuario(UsuarioModelo usuario) {
        return usuarioRepository.save(usuario);
    }

    @Transactional(readOnly = true)
    public Optional<UsuarioModelo> obtenerUsuariobyCUI(String cui, Long id) {
        return usuarioRepository.getUsuarioByCUI(cui, id);
    }

    @Transactional(readOnly = true)
    public List<UsuarioModelo> getUsuariosBySucursal(Integer id_sucursal) {
        return usuarioRepository.getUsuariosByIdSucursal(id_sucursal);
    }

}
