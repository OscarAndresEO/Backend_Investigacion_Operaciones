/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.investigacion.operaciones.controllers;

import com.investigacion.operaciones.Models.SucursalModelo;
import com.investigacion.operaciones.Services.SucursalServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
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

@RequestMapping("/api/sucursales")
@Api
@RestController
public class SucursalController {

    @Autowired
    SucursalServices sucursalServices;

    @GetMapping(value = "/")
    @ApiOperation(value = "Retorna todas las sucursal")
    public ResponseEntity getSucursales() {
        List<SucursalModelo> sucursales = (List<SucursalModelo>) sucursalServices.getSucursales();

        if (sucursales.size() == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay Sucursales disponibles.");
        }
        return ResponseEntity.ok().body(sucursales);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Retorna la sucursal correspondiente al Id")
    public ResponseEntity getSucursalesById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(sucursalServices.getSucursalById(id));
    }

    @GetMapping("/existeSucursal/{id}")
    @ApiOperation(value = "Retorna si existe la sucursal")
    public ResponseEntity<Boolean> existeSucursal(@PathVariable Integer id) {
        Optional<SucursalModelo> o = sucursalServices.getSucursalById(id);
        return ResponseEntity.ok(o.isPresent());
    }

    @PostMapping(value = "/crearSucursal")
    @ApiOperation(value = "Crea una nueva sucursal")
    public ResponseEntity<?> crearSucursal(@RequestBody SucursalModelo sucursal, BindingResult result) {
             
            return ResponseEntity.ok(sucursalServices.crearSucursal(sucursal));
    }

  
}
