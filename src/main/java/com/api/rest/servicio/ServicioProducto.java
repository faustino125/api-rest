/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest.servicio;

import com.api.rest.modelo.Producto;
import com.api.rest.repositorio.RepositorioProducto;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author FAUSTINO
 */
@Service("servicioProducto")
public class ServicioProducto {
    @Resource
    private RepositorioProducto repositorioProducto;
    
    public List<Producto> mostrarProducto(){
    return this.repositorioProducto.findAll();
    }
}
