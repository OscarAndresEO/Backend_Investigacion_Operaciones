/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.investigacion.operaciones.Services;

import com.investigacion.operaciones.Models.CompraModelo;
import com.investigacion.operaciones.Models.DetalleCompraModelo;
import com.investigacion.operaciones.Repositorys.CompraRepository;
import com.investigacion.operaciones.Repositorys.DetalleCompraRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author oscar
 */
@Service
public class CompraServices {

    @Autowired
    CompraRepository compraRepository;

    @Autowired
    DetalleCompraRepository detalleRepository;

    public List<CompraModelo> getCompras() {
        return compraRepository.findAll();
    }

    public Optional<CompraModelo> getComprasBy(Integer id) {
        return compraRepository.findById(id);
    }

    public CompraModelo saveCompra(CompraModelo compra) {
        return compraRepository.save(compra);
    }

    //----------------------------------------------------------------
    public List<DetalleCompraModelo> getDetallesByIdCompra(Integer id) {
        return detalleRepository.getDetalleCompraByIdCompra(id);
    }

    public List<DetalleCompraModelo> crearDetalleCompra(List<DetalleCompraModelo> detalle) {
        return detalleRepository.saveAll(detalle);
    }

}
