/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.investigacion.operaciones.Repositorys;

import java.util.List;
import com.investigacion.operaciones.Models.PersonaModelo;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author oscar
 */
public interface PersonaRepository extends JpaRepository<PersonaModelo, Integer> {

    @Query(value = "select * from public.persona p where p.tipo_persona = '1'", nativeQuery = true)
    List<PersonaModelo> getClientes();

    @Query(value = "select * from public.persona p where p.nit = :cNit", nativeQuery = true)
    Optional<PersonaModelo> getClienteByNit(@Param("cNit") String cNit);
    //arreglar la base de datos con el nit 

    @Query(value = "select * from public.persona p where p.tipo_persona = '0'", nativeQuery = true)
    List<PersonaModelo> getProveedores();

    @Query(value = "select * from public.persona p where p.id_persona = :pId", nativeQuery = true)
    Optional<PersonaModelo> getProveedorById(@Param("pId") Integer pId);

}
