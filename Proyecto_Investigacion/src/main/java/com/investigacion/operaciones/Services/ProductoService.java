/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.investigacion.operaciones.Services;

import com.investigacion.operaciones.Models.ColorModelo;
import com.investigacion.operaciones.Models.MarcaModelo;
import com.investigacion.operaciones.Models.ProductoModelo;
import java.util.List;
import com.investigacion.operaciones.Repositorys.ProductoRepository;
import com.investigacion.operaciones.dto.response.ProductosDto;
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
public class ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    public List<ProductosDto> getProductos() {
        return productoRepository.getProductos();
    }

    public ProductoModelo saveProducto(ProductoModelo producto) {
        return productoRepository.save(producto);
    }

    public Optional<ProductosDto> getProductoById(Integer id) {
        return productoRepository.getProductoById(id);
    }
    /*
    
    //---------------Marcas
    
    public List<MarcaModelo> getMarcas(){
        return productoRepository.getMarcas();
    }
    
    public Optional<MarcaModelo> getMarcaById(Integer id){
        return productoRepository.getMarcaById(id);
    }
    
    //---------------Colores
    
    public List<ColorModelo> getColores(){
        return productoRepository.getColores();
    }
    
    public Optional<ColorModelo> getColoresById(Integer id_color){
        return productoRepository.getColorById(id_color);
    }
     */
}
