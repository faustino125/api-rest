/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest.rest;

import com.api.rest.dto.dtoFactura;
import com.api.rest.modelo.Factura;
import com.api.rest.servicio.ServicioFactura;
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
@RequestMapping("/factura")
public class RestFactura {
    @Resource
    private ModelMapper modelMapper;
    @Resource
    private ServicioFactura servicioFactura;
    
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<dtoFactura> mostrar(){
        return this.servicioFactura.mostrarFactura()
                .stream().map(factura->this.modelMapper.map(factura, dtoFactura.class))
                .collect(Collectors.toList());
    }
    
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public dtoFactura buscar(@PathVariable Integer id){
    Factura factura=this.servicioFactura.buscarPorId(id);
    return this.modelMapper.map(factura, dtoFactura.class);
    }
}
