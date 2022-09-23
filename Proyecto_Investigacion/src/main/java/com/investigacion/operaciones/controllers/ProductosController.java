/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.investigacion.operaciones.controllers;

import com.investigacion.operaciones.Models.ProductoModelo;
import com.investigacion.operaciones.Services.ProductoService;
import com.investigacion.operaciones.dto.response.ProductosDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author oscar
 */
@CrossOrigin(origins = "http://localhost:4200/")

@RequestMapping("/api/productos")
@Api
@RestController
public class ProductosController {

    @Autowired
    ProductoService productoService;

    //-----------------------PRODUCTOS
    @GetMapping(value = "/")
    @ApiOperation(value = "Retorna el listado de los productos")
    public ResponseEntity listarProductos() {
        List<ProductosDto> productos = (List<ProductosDto>) productoService.getProductos();

        if (productos.size() == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay productos disponibles.");
        }
        return ResponseEntity.ok().body(productos);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Retorna el producto correspondiente al id")
    public ResponseEntity produtoById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(productoService.getProductoById(id));
    }

    @GetMapping("/existeProducto/{id}")
    @ApiOperation(value = "Retorna si existe un producto")
    public ResponseEntity<Boolean> existeProducto(@PathVariable("id") Integer id) {
        Optional<ProductosDto> o = this.productoService.getProductoById(id);
        return ResponseEntity.ok(o.isPresent());
    }

    @PostMapping("/crearProducto")
    @ApiOperation(value = "Crea un nuevo Producto")
    public ResponseEntity<?> crearProducto(@RequestBody ProductoModelo producto, BindingResult result) {
        if (result.hasErrors()) {
            return this.validar(result);
        }
        Boolean existeProducto = existeProducto(producto.getId_producto()).getBody();
        if (existeProducto) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("El producto ya existe");
        } else {
            return ResponseEntity.ok(this.productoService.saveProducto(producto));
        }
    }

    public ResponseEntity<?> validar(BindingResult result) {
        Map<String, Object> errores = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errores.put(err.getField(), err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }

    /*
    //--------------------MARCAS-------------------
     @GetMapping(value = "/marcas")
    @ApiOperation(value = "Retorna el listado de las marcas")
    public ResponseEntity listarMarcas() {
        List<MarcaModelo> marcas = (List<MarcaModelo>) productoService.getMarcas();

        if (marcas.size() == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay marcas disponibles");
        }
        return ResponseEntity.ok().body(marcas);
    }

    @GetMapping(value = "/marcas/{id}")
    @ApiOperation(value = "Retorna el producto correspondiente al id")
    public ResponseEntity marcaById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(productoService.getMarcaById(id));
    }
    
    
    //-----------------------COLORES-----------------
    
      @GetMapping(value = "/colores")
    @ApiOperation(value = "Retorna el listado de los colores")
    public ResponseEntity listarColores() {
        List<ColorModelo> colores = (List<ColorModelo>) productoService.getColores();

        if (colores.size() == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay marcas disponibles");
        }
        return ResponseEntity.ok().body(colores);
    }

    @GetMapping(value = "/marcas/{id_color}")
    @ApiOperation(value = "Retorna el producto correspondiente al id")
    public ResponseEntity colorById(@PathVariable("id") Integer id_color) {
        return ResponseEntity.ok(productoService.getColoresById(id_color));
    }*/
}
