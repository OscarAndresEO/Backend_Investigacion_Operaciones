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
@Table(name = "productos",
        schema = "public")
public class ProductoModelo implements java.io.Serializable {

    private Integer id_producto;
    private String nombre_producto;
    private Integer id_marca;//marca
    private String talla;
    private Integer id_color;//color
    private Integer precio;
    private Integer existencia;

    @Id
    @Column(name = "id_producto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    @Column(name = "nombre_producto")
    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    @Column(name = "id_marca")
    public Integer getId_marca() {
        return id_marca;
    }

    public void setId_marca(Integer id_marca) {
        this.id_marca = id_marca;
    }

    @Column(name = "talla")
    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    @Column(name = "id_color")
    public Integer getId_color() {
        return id_color;
    }

    public void setId_color(Integer id_color) {
        this.id_color = id_color;
    }

    @Column(name = "precio")
    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    @Column(name = "existencia")
    public Integer getExistencia() {
        return existencia;
    }

    public void setExistencia(Integer existencia) {
        this.existencia = existencia;
    }

    public ProductoModelo() {
    }

    public ProductoModelo(Integer id_producto, String nombre_producto, Integer id_marca, String talla, Integer id_color, Integer precio, Integer existencia) {
        this.id_producto = id_producto;
        this.nombre_producto = nombre_producto;
        this.id_marca = id_marca;
        this.talla = talla;
        this.id_color = id_color;
        this.precio = precio;
        this.existencia = existencia;
    }

}
