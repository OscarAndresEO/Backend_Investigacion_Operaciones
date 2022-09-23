/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.investigacion.operaciones.Services;

import com.investigacion.operaciones.Models.DetalleVentaModelo;
import com.investigacion.operaciones.Models.VentaModelo;
import com.investigacion.operaciones.Repositorys.DetalleVentaRepository;
import com.investigacion.operaciones.Repositorys.VentaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author oscar
 */
@Transactional
@Service
public class VentaServices {

    @Autowired
    VentaRepository ventaRepository;

    @Autowired
    DetalleVentaRepository detalleRepository;

    public List<VentaModelo> getVentas() {
        return ventaRepository.findAll();
    }

    public Optional<VentaModelo> getVentasBy(Integer id) {
        return ventaRepository.findById(id);
    }

    public VentaModelo crearVenta(VentaModelo venta) {
        return ventaRepository.save(venta);
    }

    public List<VentaModelo> getVentasByIdSucursal(Integer id) {
        return ventaRepository.getDetalleVentaByIdSucursal(id);
    }

    //--------------------------------------------------------------------
    public List<DetalleVentaModelo> getDetallesByIdVenta(Integer id) {
        return detalleRepository.getDetalleVentaById(id);
    }

    public List<DetalleVentaModelo> crearDetalleVenta(List<DetalleVentaModelo> detalle) {
        return detalleRepository.saveAll(detalle);
    }

}
