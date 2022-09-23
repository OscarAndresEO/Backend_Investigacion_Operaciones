/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.investigacion.operaciones.controllers;

import com.investigacion.operaciones.Models.DetalleVentaModelo;
import com.investigacion.operaciones.Models.SucursalModelo;
import com.investigacion.operaciones.Models.VentaModelo;
import com.investigacion.operaciones.Services.VentaServices;
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

@RequestMapping("/api/ventas")
@Api
@RestController
public class VentasController {

    @Autowired
    VentaServices ventaService;

    @GetMapping(value = "/")
    @ApiOperation(value = "Retorna todas las ventas")
    public ResponseEntity getVenta() {
        List<VentaModelo> ventas = (List<VentaModelo>) ventaService.getVentas();

        if (ventas.size() == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay ventas disponibles.");
        }
        return ResponseEntity.ok().body(ventas);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Retorna la venta correspondiente al Id")
    public ResponseEntity getVentaById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(ventaService.getVentasBy(id));
    }

    @GetMapping("/existeVenta/{id}")
    @ApiOperation(value = "Retorna si existe una venta")
    public ResponseEntity<Boolean> existeVenta(@PathVariable Integer id) {
        Optional<VentaModelo> o = ventaService.getVentasBy(id);
        return ResponseEntity.ok(o.isPresent());
    }

    @GetMapping(value = "BySucursal/{id}")
    @ApiOperation(value = "Retorna todas las ventas de una sucursal")
    public ResponseEntity getVentaByIdSucursal(@PathVariable("id") Integer id) {
        List<VentaModelo> ventas = (List<VentaModelo>) ventaService.getVentasByIdSucursal(id);

        if (ventas.size() == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay ventas disponibles.");
        }
        return ResponseEntity.ok().body(ventas);
    }

    @PostMapping(value = "/crearVenta")
    @ApiOperation(value = "Crea una nueva venta")
    public ResponseEntity<?> crearSucursal(@RequestBody VentaModelo venta, BindingResult result) {
        if (result.hasErrors()) {
            return this.validar(result);
        }
        Boolean existeVenta = existeVenta(venta.getId_usuario()).getBody();
        if (existeVenta) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Venta ya existe");
        } else {
            return ResponseEntity.ok(ventaService.crearVenta(venta));
        }
    }

    public ResponseEntity<?> validar(BindingResult result) {
        Map<String, Object> errores = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errores.put(err.getField(), err.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(errores);
    }

    ////---------------------------------------------------------------------------------------------
    @ApiOperation(value = "Retorna todo el detalle de la venta")
    @GetMapping(value = "/DetalleVentaByIdVenta/{id}")
    public ResponseEntity getDetalleVenta(@PathVariable Integer id) {
        List<DetalleVentaModelo> ventas = (List<DetalleVentaModelo>) ventaService.getDetallesByIdVenta(id);

        if (ventas.size() == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay detalles disponibles al id de la venta " + id);
        }
        return ResponseEntity.ok().body(ventas);
    }

    @PostMapping(value = "/CrearDetalleVenta")
    @ApiOperation(value = "Crea Detalles para la venta")
    public ResponseEntity<?> crearDetalles(@RequestBody List<DetalleVentaModelo> detalles) {
        return ResponseEntity.ok(ventaService.crearDetalleVenta(detalles));
    }

}
