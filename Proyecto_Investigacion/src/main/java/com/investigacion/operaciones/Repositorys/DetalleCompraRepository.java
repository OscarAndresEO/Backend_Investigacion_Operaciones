/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.investigacion.operaciones.Repositorys;

import com.investigacion.operaciones.Models.DetalleCompraModelo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author oscar
 */
public interface DetalleCompraRepository extends JpaRepository<DetalleCompraModelo, Integer> {

    @Query(value = "select * from public.detalle_compra dc where dc.id_compra = :id", nativeQuery = true)
    List<DetalleCompraModelo> getDetalleCompraByIdCompra(@PathVariable Integer id);

}
