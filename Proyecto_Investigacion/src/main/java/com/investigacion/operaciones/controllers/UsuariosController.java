/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.investigacion.operaciones.controllers;

import com.investigacion.operaciones.Models.UsuarioModelo;
import com.investigacion.operaciones.Services.UsuariosServices;
import com.investigacion.operaciones.dto.request.LoginDto;
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

@RequestMapping("/api/usuarios")
@Api
@RestController
public class UsuariosController {

    @Autowired
    UsuariosServices usuarioservice;

    @PostMapping("/login")
    @ApiOperation(value = "Retorna todos los atributos del usuario")
    public ResponseEntity<Optional<UsuarioModelo>> login(@RequestBody LoginDto dto) {
        return ResponseEntity.ok(usuarioservice.login(dto));
    }

    @GetMapping("/porSucursal/{id_sucursal}")
    @ApiOperation(value = "Retorna todos los usuarios de una sucursal")
    public ResponseEntity<List<UsuarioModelo>> obtenerUsuariosBySucursal(@PathVariable("id_sucursal") Integer id_sucursal) {
        return ResponseEntity.ok(usuarioservice.getUsuariosBySucursal(id_sucursal));
    }

    @GetMapping("/{cui}")
    @ApiOperation(value = "Retorna el usuario correspondiente al cui/id")
    public ResponseEntity<Optional<UsuarioModelo>> obtenerUsuarioById(@PathVariable String cui) {
        Long id = Long.parseLong(cui);
        return ResponseEntity.ok(usuarioservice.obtenerUsuariobyCUI(cui, id));
    }

    @GetMapping("/existeUsuario/{cui}")
    @ApiOperation(value = "Retorna si existe el usuario al cui/id")
    public ResponseEntity<Boolean> existeUsuario(@PathVariable String cui) {
        Long id = Long.parseLong(cui);
        Optional<UsuarioModelo> o = usuarioservice.obtenerUsuariobyCUI(cui, id);
        return ResponseEntity.ok(o.isPresent());
    }

    @PostMapping("/crearUsuario")
    @ApiOperation(value = "crear un nuevo usuario")
    public ResponseEntity<?> crearUsuario(@RequestBody UsuarioModelo usuario, BindingResult result) {
        if (result.hasErrors()) {
            return this.validar(result);
        }
        Boolean existeUsuario = existeUsuario(usuario.getCui()).getBody();
        if (existeUsuario) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("El cui del usuario ya existe.");
        } else {
            return ResponseEntity.ok(usuarioservice.crearUsuario(usuario));
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
