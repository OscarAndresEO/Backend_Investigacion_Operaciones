/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.investigacion.operaciones.Repositorys;

import com.investigacion.operaciones.Models.ColorModelo;
import com.investigacion.operaciones.Models.MarcaModelo;
import com.investigacion.operaciones.Models.ProductoModelo;
import com.investigacion.operaciones.dto.response.ProductosDto;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author oscar
 */
public interface ProductoRepository extends JpaRepository<ProductoModelo, Integer> {

    @Query(value = " select p.id_producto,p.nombre_producto,p.id_marca,m.descripcion_marca as marca,talla, p.id_color, c.descripcion as color, precio, existencia"
            + " from productos p \n"
            + "   inner join  color c  on c.id_color = p.id_color  \n"
            + "   inner join  marca m  on m.id_marca = p.id_marca ;", nativeQuery = true)
    public List<ProductosDto> getProductos();

    @Query(value = " select p.id_producto,p.nombre_producto,p.id_marca,m.descripcion_marca as marca,talla, p.id_color, c.descripcion as color, precio, existencia"
            + " from productos p \n"
            + "   inner join  color c  on c.id_color = p.id_color  \n"
            + "   inner join  marca m  on m.id_marca = p.id_marca where p.id_producto = :id ;", nativeQuery = true)
    public Optional<ProductosDto> getProductoById(@Param("id") Integer id);

    //-----------------Marcas---------------
    @Query(value = "select * from marca", nativeQuery = true)
    public List<MarcaModelo> getMarcas();

    @Query(value = "select * from marca m where m.id_marca = :id", nativeQuery = true)
    public Optional<MarcaModelo> getMarcaById(@Param("id") Integer id);

    //----------------Colores------------------
    @Query(value = "select * from color", nativeQuery = true)
    public List<ColorModelo> getColores();

    @Query(value = "select * from color c where c.id_color = :id_color", nativeQuery = true)
    public Optional<ColorModelo> getColorById(@Param("id_color") Integer id_color);

}
