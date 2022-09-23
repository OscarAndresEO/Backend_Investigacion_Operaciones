/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.investigacion.operaciones.controllers;

import com.investigacion.operaciones.Models.CompraModelo;
import com.investigacion.operaciones.Models.DetalleCompraModelo;
import com.investigacion.operaciones.Services.CompraServices;
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

@RequestMapping("/api/compras")
@RestController
@Api
public class ComprasController {

    @Autowired
    CompraServices compraServices;

    @GetMapping(value = "/")
    @ApiOperation(value = "Retorna todas las compras")
    public ResponseEntity getVenta() {
        List<CompraModelo> compras = (List<CompraModelo>) compraServices.getCompras();

        if (compras.size() == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay compras disponibles.");
        }
        return ResponseEntity.ok().body(compras);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Retorna la compra correspondiente al Id")
    public ResponseEntity getCompraById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(compraServices.getComprasBy(id));
    }

    @GetMapping("/existeCompra/{id}")
    @ApiOperation(value = "Retorna si existe una compra")
    public ResponseEntity<Boolean> existeCompra(@PathVariable Integer id) {
        Optional<CompraModelo> o = compraServices.getComprasBy(id);
        return ResponseEntity.ok(o.isPresent());
    }

    @PostMapping(value = "/crearCompra")
    @ApiOperation(value = "Crea una nueva compra")
    public ResponseEntity<?> crearSucursal(@RequestBody CompraModelo compra, BindingResult result) {
        if (result.hasErrors()) {
            return this.validar(result);
        }
        Boolean existeVenta = existeCompra(compra.getId_compra()).getBody();
        if (existeVenta) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("La Compra ya existe");
        } else {
            return ResponseEntity.ok(compraServices.saveCompra(compra));
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
    @ApiOperation(value = "Retorna todas los detalles de la compra")
    @GetMapping(value = "/DetalleCompra/{id}")
    public ResponseEntity getDetalleCompra(@PathVariable Integer id) {
        List<DetalleCompraModelo> compras = (List<DetalleCompraModelo>) compraServices.getDetallesByIdCompra(id);

        if (compras.size() == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay detalles disponibles al id de la compra " + id);
        }
        return ResponseEntity.ok().body(compras);
    }

    @PostMapping(value = "/CrearDetalleCompra")
    @ApiOperation(value = "Crea Detalles para la compra")
    public ResponseEntity<?> crearDetalles(@RequestBody List<DetalleCompraModelo> detalles) {
        return ResponseEntity.ok(compraServices.crearDetalleCompra(detalles));
    }

}
