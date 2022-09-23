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
@Table(name = "color",
        schema = "public")
public class ColorModelo implements java.io.Serializable {

    @Id
    @Column(name = "id_color")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_color;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_creacion")
    private Date fecha_creacion;

    @Column(name = "fecha_modificacion")
    private Date fecha_modificacion;

    public Integer getId_color() {
        return id_color;
    }

    public void setId_color(Integer id_color) {
        this.id_color = id_color;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public ColorModelo() {
    }

    public ColorModelo(Integer id_color, String descripcion, Date fecha_creacion, Date fecha_modificacion) {
        this.id_color = id_color;
        this.descripcion = descripcion;
        this.fecha_creacion = fecha_creacion;
        this.fecha_modificacion = fecha_modificacion;
    }

}
