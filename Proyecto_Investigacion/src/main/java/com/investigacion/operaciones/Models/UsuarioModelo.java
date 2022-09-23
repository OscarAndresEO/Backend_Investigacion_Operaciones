/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.investigacion.operaciones.Models;

import java.math.BigDecimal;
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
@Table(name = "usuario",
        schema = "public")
public class UsuarioModelo implements java.io.Serializable {

    private Integer id_usuario;
    private Integer id_sucursal;
    private String nombre;
    private String direccion;
    private String email;
    private String cui;
    private Integer celular;
    private Integer telefono_fijo;
    private String username;
    private String clave;
    private String rol;
    private Date fecha_creacion;
    private Date fecha_modificacion;

    //private SucursalModelo sucursal;
    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    @Column(name = "id_sucursal")
    public Integer getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(Integer id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    @Column(name = "nombre", nullable = false)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "direccion")
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "cui", nullable = false)
    public String getCui() {
        return cui;
    }

    public void setCui(String cui) {
        this.cui = cui;
    }

    @Column(name = "celular", nullable = false)
    public Integer getCelular() {
        return celular;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    @Column(name = "telefono_fijo")
    public Integer getTelefono_fijo() {
        return telefono_fijo;
    }

    public void setTelefono_fijo(Integer telefono_fijo) {
        this.telefono_fijo = telefono_fijo;
    }

    @Column(name = "username", nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "clave", nullable = false)
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Column(name = "rol", nullable = false)
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Column(name = "fecha_creacion")
    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    @Column(name = "fecha_modificacion")
    public Date getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(Date fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

    public UsuarioModelo() {
    }

    public UsuarioModelo(Integer id_usuario, Integer id_sucursal, String nombre, String direccion, String email, String cui, Integer celular, Integer telefono_fijo, String username, String clave, String rol, Date fecha_creacion, Date fecha_modificacion) {
        this.id_usuario = id_usuario;
        this.id_sucursal = id_sucursal;
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.cui = cui;
        this.celular = celular;
        this.telefono_fijo = telefono_fijo;
        this.username = username;
        this.clave = clave;
        this.rol = rol;
        this.fecha_creacion = fecha_creacion;
        this.fecha_modificacion = fecha_modificacion;
    }

}
