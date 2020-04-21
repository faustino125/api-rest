/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest.rest;

import com.api.rest.dto.dtoCliente;
import com.api.rest.modelo.Cliente;
import com.api.rest.servicio.ServicioCliente;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author FAUSTINO
 */
@RestController
@RequestMapping("/cliente")
public class RestCliente {

    @Resource
    private ModelMapper modelMapper;
    @Resource
    private ServicioCliente servicioCliente;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<dtoCliente> mostrar() {
        return this.servicioCliente.mostrarCliente()
                .stream().map(cliente -> this.modelMapper.map(cliente, dtoCliente.class))
                .collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public dtoCliente buscar(@PathVariable Integer id) {
        Cliente cliente = this.servicioCliente.buscarPorId(id);
        return this.modelMapper.map(cliente, dtoCliente.class);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public dtoCliente agregar(@RequestBody @Valid dtoCliente dto) {
        Cliente cliente = this.servicioCliente.agregar(dto);
        return this.modelMapper.map(cliente, dtoCliente.class);
    }

}
