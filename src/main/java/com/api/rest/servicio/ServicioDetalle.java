/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest.servicio;

import com.api.rest.excepcion.Errores;
import com.api.rest.modelo.Detalle;
import com.api.rest.repositorio.RepositorioDetalle;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 *
 * @author FAUSTINO
 */
@Service("servicioDetalle")
public class ServicioDetalle {

    @Resource
    private RepositorioDetalle repositorioDetalle;

    public List<Detalle> mostrarDetalle() {
        return this.repositorioDetalle.findAll();
    }
    
    public Detalle buscarPorId(Integer id){
    return this.repositorioDetalle.findById(id).orElseThrow(()->{
    String descripcion=String.format("No existe id: ", id);
    return new Errores(HttpStatus.NOT_FOUND, descripcion);
    });
    }
    
}
