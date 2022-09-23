/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.investigacion.operaciones.Repositorys;

import com.investigacion.operaciones.Models.CompraModelo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author oscar
 */
public interface CompraRepository extends JpaRepository<CompraModelo, Integer> {

}
