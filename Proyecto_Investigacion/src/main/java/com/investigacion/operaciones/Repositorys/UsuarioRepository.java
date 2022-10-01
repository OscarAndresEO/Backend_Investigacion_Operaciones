/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.investigacion.operaciones.Repositorys;

import com.investigacion.operaciones.Models.UsuarioModelo;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author oscar
 */
public interface UsuarioRepository extends JpaRepository<UsuarioModelo, Integer> {

    @Query(value = "select * from public.usuario u where u.username = :username and u.clave = :clave", nativeQuery = true)
    Optional<UsuarioModelo> findByUsernameAndPassword(@Param("username") String username, @Param("clave") String clave);

    @Query(value = "select * from public.usuario u where u.cui = :cui or u.id_usuario = :id", nativeQuery = true)
    Optional<UsuarioModelo> getUsuarioByCUI(@Param("cui") String cui, @Param("id") Long id);

    @Query(value = "select * from public.usuario u where u.id_sucursal = :id_sucursal", nativeQuery = true)
    List<UsuarioModelo> getUsuariosByIdSucursal(@Param("id_sucursal") Integer id_sucursal);

}
