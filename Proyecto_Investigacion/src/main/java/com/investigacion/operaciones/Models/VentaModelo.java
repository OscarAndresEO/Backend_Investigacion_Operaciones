/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.investigacion.operaciones.Models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author oscar
 */
@Entity
@Table(name = "ventas",
        schema = "public")
public class VentaModelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_venta;
    private Date fecha_venta;
    private Integer total_venta;
    private String usuario_creacion;
    private String nit_persona;

    public Integer getId_venta() {
        return id_venta;
    }

    public void setId_venta(Integer id_venta) {
        this.id_venta = id_venta;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public Integer getTotal_venta() {
        return total_venta;
    }

    public void setTotal_venta(Integer total_venta) {
        this.total_venta = total_venta;
    }

    public String getUsuario_creacion() {
        return usuario_creacion;
    }

    public void setUsuario_creacion(String usuario_creacion) {
        this.usuario_creacion = usuario_creacion;
    }


    public String getNit_persona() {
        return nit_persona;
    }

    public void setNit_persona(String nit_persona) {
        this.nit_persona = nit_persona;
    }

    public VentaModelo() {
    }

    public VentaModelo(Integer id_venta, Date fecha_venta, Integer total_venta, String usuario_creacion, String nit_persona) {
        this.id_venta = id_venta;
        this.fecha_venta = fecha_venta;
        this.total_venta = total_venta;
        this.usuario_creacion = usuario_creacion;
        this.nit_persona = nit_persona;
    }

  

}
