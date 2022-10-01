/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.investigacion.operaciones.Models;

import java.util.Date;
import javax.persistence.Column;
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
@Table(name = "Sucursal",
        schema = "public"
)
public class SucursalModelo implements java.io.Serializable {

    @Id
    @Column(name = "id_sucursal", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_sucursal;

    @Column(name = "direccion_sucursal", length = 64)
    private String direccion_sucursal;

    @Column(name = "nombre_sucursal", length = 64)
    private String nombre_sucursal;

    @Column(name = "ubicacion_sucursal", length = 64)
    private String ubicacion_sucursal;
    
    @Column(name = "usuario_creacion", length = 15)
    private String usuario_creacion;

    @Column(name = "fecha_creacion")
    private Date fecha_creacion;

    @Column(name = "fecha_modificacion")
    private Date fecha_modificacion;

    /*
    @OneToMany(mappedBy = "Usuario")
    private List<UsuarioModelo> usuarios;
    
     */

    public SucursalModelo() {
    }

    public SucursalModelo(Integer id_sucursal, String direccion_sucursal, String nombre_sucursal, String ubicacion_sucursal, String usuario_creacion, Date fecha_creacion, Date fecha_modificacion) {
        this.id_sucursal = id_sucursal;
        this.direccion_sucursal = direccion_sucursal;
        this.nombre_sucursal = nombre_sucursal;
        this.ubicacion_sucursal = ubicacion_sucursal;
        this.usuario_creacion = usuario_creacion;
        this.fecha_creacion = fecha_creacion;
        this.fecha_modificacion = fecha_modificacion;
    }

    public String getUsuario_creacion() {
        return usuario_creacion;
    }

    public void setUsuario_creacion(String usuario_creacion) {
        this.usuario_creacion = usuario_creacion;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Date getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(Date fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }
  

    public Integer getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(Integer id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public String getDireccion_sucursal() {
        return direccion_sucursal;
    }

    public void setDireccion_sucursal(String direccion_sucursal) {
        this.direccion_sucursal = direccion_sucursal;
    }

    public String getNombre_sucursal() {
        return nombre_sucursal;
    }

    public void setNombre_sucursal(String nombre_sucursal) {
        this.nombre_sucursal = nombre_sucursal;
    }

    public String getUbicacion_sucursal() {
        return ubicacion_sucursal;
    }

    public void setUbicacion_sucursal(String ubicacion_sucursal) {
        this.ubicacion_sucursal = ubicacion_sucursal;
    }

}
