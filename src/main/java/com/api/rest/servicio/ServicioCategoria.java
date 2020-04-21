/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest.servicio;

import com.api.rest.dto.dtoCategoria;
import com.api.rest.excepcion.Errores;
import com.api.rest.modelo.Categoria;
import com.api.rest.repositorio.RepositorioCategoria;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 *
 * @author FAUSTINO
 */
@Service("servicioCategoria")
public class ServicioCategoria {

    @Resource
    private RepositorioCategoria repositorioCategoria;

    public List<Categoria> mostarCategoria() {
        return this.repositorioCategoria.findAll();
    }

    public Categoria buscarPorId(Integer id) {
        return this.repositorioCategoria.findById(id).orElseThrow(() -> {
            String descripcion = String.format("No existe un puesto con el id '%s'", id);
            return new Errores(HttpStatus.NOT_FOUND, descripcion);
        });
    }

    public Categoria agregar(dtoCategoria dto) {
        Categoria categoria = new Categoria();
        categoria.setNombre(dto.getNombre());
        categoria.setDescripcion(dto.getDescripcion());
        this.repositorioCategoria.save(categoria);
        return categoria;
    }
}
