/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.investigacion.operaciones.Services;

import com.investigacion.operaciones.Models.PersonaModelo;
import com.investigacion.operaciones.Repositorys.PersonaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author oscar
 */
@Transactional
@Service
public class PersonaServices {

    @Autowired
    PersonaRepository personaRepository;

    public List<PersonaModelo> getClientes() {
        return personaRepository.getClientes();
    }

    public Optional<PersonaModelo> getClientesByNit(String nit) {
        return personaRepository.getClienteByNit(nit);
    }

    public List<PersonaModelo> getProveedores() {
        return personaRepository.getProveedores();
    }

    public Optional<PersonaModelo> getProveedoresById(Integer id) {
        return personaRepository.getProveedorById(id);
    }

    public PersonaModelo crearPersona(PersonaModelo persona) {
        return personaRepository.save(persona);
    }
}
