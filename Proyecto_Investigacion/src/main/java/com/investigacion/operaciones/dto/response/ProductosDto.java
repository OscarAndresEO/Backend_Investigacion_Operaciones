/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.investigacion.operaciones.dto.response;

/**
 *
 * @author oscar
 */
public interface ProductosDto {

    Integer getId_producto();

    String getNombre_producto();

    Integer getId_marca();

    String getMarca();

    String getTalla();

    Integer getId_color();

    String getColor();

    Integer getPrecio();

    Integer getExistencia();
}
