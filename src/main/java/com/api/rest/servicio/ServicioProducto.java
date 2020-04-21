/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest.servicio;

import com.api.rest.dto.dtoProducto;
import com.api.rest.excepcion.Errores;
import com.api.rest.modelo.Categoria;
import com.api.rest.modelo.Producto;
import com.api.rest.repositorio.RepositorioProducto;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 *
 * @author FAUSTINO
 */
@Service("servicioProducto")
public class ServicioProducto {

    @Resource
    private RepositorioProducto repositorioProducto;
    @Resource
    private ServicioCategoria servicioCategoria;

    public List<Producto> mostrarProducto() {
        return this.repositorioProducto.findAll();
    }

    public Producto buscarPorId(Integer id) {
        return this.repositorioProducto.findById(id).orElseThrow(() -> {
            String descripcion = String.format("No existe el id:", id);
            return new Errores(HttpStatus.NOT_FOUND, descripcion);
        });
    }

    public Producto agregar(dtoProducto dto) {
        Categoria categoria = this.servicioCategoria.buscarPorId(dto.getCategoriaId());
        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setPrecio(dto.getPrecio());
        producto.setCantidad(dto.getCantidad());
        producto.setCategoria(categoria);
        this.repositorioProducto.save(producto);
        return producto;
    }

}
