/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.investigacion.operaciones.controllers;

import com.investigacion.operaciones.Models.PersonaModelo;
import com.investigacion.operaciones.Models.SucursalModelo;
import java.util.List;
import com.investigacion.operaciones.Services.PersonaServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
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
@RequestMapping("/api/personas")
@Api
@RestController
public class PersonaController {

    @Autowired
    PersonaServices personaService;

    @GetMapping(value = "/clientes")
    @ApiOperation(value = "Retorna el listado de clientes")
    public ResponseEntity listarClientes() {
        List<PersonaModelo> clientes = (List<PersonaModelo>) personaService.getClientes();

        if (clientes.size() == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay clientes disponibles.");
        }
        return ResponseEntity.ok().body(clientes);
    }

    @GetMapping(value = "/clientes/{nit}")
    @ApiOperation(value = "Retorna el cliente correspondiente al nit")
    public ResponseEntity ClientesByNit(@PathVariable("nit") String nit) {
        return ResponseEntity.ok(personaService.getClientesByNit(nit));
    }

    @GetMapping(value = "/proveedores")
    @ApiOperation(value = "Retorna el listado de proveedores")
    public ResponseEntity listarProveedores() {
        List<PersonaModelo> proveedores = (List<PersonaModelo>) personaService.getProveedores();

        if (proveedores.size() == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay proveedores disponibles.");
        }
        return ResponseEntity.ok().body(proveedores);
    }

    @GetMapping(value = "/proveedores/{id}")
    @ApiOperation(value = "Retorna el proveedor correspondiente al id")
    public ResponseEntity ProveedoresById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(personaService.getProveedoresById(id));
    }

    @GetMapping("/existeCliente/{nit}")
    @ApiOperation(value = "Retorna si existe un cliente")
    public ResponseEntity<Boolean> existeCliente(@PathVariable String nit) {
        Optional<PersonaModelo> o = this.personaService.getClientesByNit(nit);
        return ResponseEntity.ok(o.isPresent());
    }

    @PostMapping("/crearPersona")
    public ResponseEntity<?> crearPersona(@RequestBody PersonaModelo persona, BindingResult result) {
        if (result.hasErrors()) {
            return this.validar(result);
        }
        Boolean existeCliente = existeCliente(persona.getNit()).getBody();
        if (existeCliente) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("El cliente ya existe");
        } else {
            return ResponseEntity.ok(this.personaService.crearPersona(persona));
        }
    }

    public ResponseEntity<?> validar(BindingResult result) {
        Map<String, Object> errores = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errores.put(err.getField(), err.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(errores);
    }
}
