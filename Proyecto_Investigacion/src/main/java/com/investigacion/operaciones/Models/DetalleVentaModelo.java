/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.investigacion.operaciones.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author oscar
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "detalle_venta",
        schema = "public")
@Entity
public class DetalleVentaModelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_detalle;
    private Integer id_venta;
    private Integer id_producto;
    private Integer cantidad;
}
