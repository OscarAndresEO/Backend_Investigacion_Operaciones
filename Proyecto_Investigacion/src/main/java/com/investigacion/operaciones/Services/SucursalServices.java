/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.investigacion.operaciones.Services;

import com.investigacion.operaciones.Models.SucursalModelo;
import com.investigacion.operaciones.Repositorys.SucursalRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author oscar
 */
@Service
@Transactional
public class SucursalServices {

    @Autowired
    SucursalRepository sucursalRepository;

    @Transactional(readOnly = true)
    public List<SucursalModelo> getSucursales() {
        return this.sucursalRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<SucursalModelo> getSucursalById(Integer id) {
        return this.sucursalRepository.findById(id);
    }

    @Transactional(readOnly = false)
    public SucursalModelo crearSucursal(SucursalModelo sucursal) {
        return this.sucursalRepository.save(sucursal);
    }

}
