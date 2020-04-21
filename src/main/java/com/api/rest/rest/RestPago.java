/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest.rest;

import com.api.rest.dto.dtoPago;
import com.api.rest.modelo.Pago;
import com.api.rest.servicio.ServicioPago;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author FAUSTINO
 */
@RestController
@RequestMapping("/pago")
public class RestPago {

    @Resource
    private ModelMapper modelMapper;
    @Resource
    private ServicioPago servicioPago;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<dtoPago> mostrar() {
        return this.servicioPago.mostrarPago()
                .stream()
                .map(pago -> this.modelMapper.map(pago, dtoPago.class))
                .collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public dtoPago buscar(@PathVariable Integer id) {
        Pago pago = this.servicioPago.buscarPOrId(id);
        return this.modelMapper.map(pago, dtoPago.class);
    }
    
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public dtoPago agregar(@RequestBody @Valid dtoPago dto){
        Pago pago=this.servicioPago.agregar(dto);
        return this.modelMapper.map(pago, dtoPago.class);
    }
    
}
