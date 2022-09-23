/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.investigacion.operaciones.Repositorys;

import com.investigacion.operaciones.Models.DetalleVentaModelo;
import com.investigacion.operaciones.Models.VentaModelo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author oscar
 */
public interface VentaRepository extends JpaRepository<VentaModelo, Integer> {

    @Query(value = "select v.id_venta, v.fecha_venta, v.total_venta, v.id_usuario, v.nit_persona  from ventas v"
            + " inner join usuario u on u.id_usuario = v.id_usuario "
            + "inner join sucursal s on s.id_sucursal = u.id_sucursal where s.id_sucursal = :id", nativeQuery = true)
    List<VentaModelo> getDetalleVentaByIdSucursal(@PathVariable Integer id);
}
