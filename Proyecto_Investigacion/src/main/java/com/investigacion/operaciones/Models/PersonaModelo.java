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
@Table(name = "persona",
        schema = "public")
public class PersonaModelo implements java.io.Serializable {

    private Integer id_persona;
    private String tipo_persona;
    private String nombre;
    private String nit;
    private String direccion;
    private Integer celular;
    private Integer telefono_fijo;
    private String pagina_web;
    private Date fecha_creacion;
    private Date fecha_modificacion;
    private String usuario;

    @Id
    @Column(name = "id_persona", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId_persona() {
        return id_persona;
    }

    public void setId_persona(Integer id_persona) {
        this.id_persona = id_persona;
    }

    @Column(name = "tipo_persona", nullable = false)
    public String getTipo_persona() {
        return tipo_persona;
    }

    public void setTipo_persona(String tipo_persona) {
        this.tipo_persona = tipo_persona;
    }

    @Column(name = "nombre", nullable = false)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "nit", nullable = false)
    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    @Column(name = "direccion", nullable = false)
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Column(name = "celular")
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

    @Column(name = "pagina_web")
    public String getPagina_web() {
        return pagina_web;
    }

    public void setPagina_web(String pagina_web) {
        this.pagina_web = pagina_web;
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

    @Column(name = "usuario", nullable = false)
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public PersonaModelo() {
    }

    public PersonaModelo(Integer id_persona, String tipo_persona, String nombre, String nit, String direccion, Integer celular, Integer telefono_fijo, String pagina_web, Date fecha_creacion, Date fecha_modificacion, String usuario) {
        this.id_persona = id_persona;
        this.tipo_persona = tipo_persona;
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        this.celular = celular;
        this.telefono_fijo = telefono_fijo;
        this.pagina_web = pagina_web;
        this.fecha_creacion = fecha_creacion;
        this.fecha_modificacion = fecha_modificacion;
        this.usuario = usuario;
    }

}
