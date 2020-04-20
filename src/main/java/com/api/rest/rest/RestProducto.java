/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest.rest;


import com.api.rest.dto.dtoProducto;
import com.api.rest.modelo.Producto;
import com.api.rest.servicio.ServicioProducto;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author FAUSTINO
 */
@RestController
@RequestMapping("/producto")
public class RestProducto {
    @Resource
    private ModelMapper modelMapper;
    @Resource
    private ServicioProducto servicioProducto;
    
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<dtoProducto> buscar() {
        return this.servicioProducto.mostrarProducto()
                .stream()
                .map(producto -> this.modelMapper.map(producto, dtoProducto.class))
                .collect(Collectors.toList());
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public dtoProducto buscarPorId(@PathVariable Integer id){
    Producto producto=this.servicioProducto.buscarPorId(id);
    return this.modelMapper.map(producto, dtoProducto.class);
    }
    
}
