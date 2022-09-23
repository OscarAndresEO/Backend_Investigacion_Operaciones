/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.investigacion.operaciones.Models;

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

    /*
    @OneToMany(mappedBy = "Usuario")
    private List<UsuarioModelo> usuarios;
    
     */
    public SucursalModelo() {
    }

    public SucursalModelo(Integer id_sucursal, String direccion_sucursal, String nombre_sucursal, String ubicacion_sucursal) {
        this.id_sucursal = id_sucursal;
        this.direccion_sucursal = direccion_sucursal;
        this.nombre_sucursal = nombre_sucursal;
        this.ubicacion_sucursal = ubicacion_sucursal;

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
