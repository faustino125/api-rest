/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest.rest;

import com.api.rest.dto.dtoDetalle;
import com.api.rest.modelo.Detalle;
import com.api.rest.servicio.ServicioDetalle;
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
@RequestMapping("/detalle")
public class RestDetalle {

    @Resource
    private ModelMapper modelMapper;
    @Resource
    private ServicioDetalle servicioDetalle;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<dtoDetalle> mostrar() {
        return this.servicioDetalle.mostrarDetalle().stream()
                .map(detalle -> this.modelMapper.map(detalle, dtoDetalle.class))
                .collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public dtoDetalle buscar(@PathVariable Integer id) {
        Detalle detalle = this.servicioDetalle.buscarPorId(id);
        return this.modelMapper.map(detalle, dtoDetalle.class);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public dtoDetalle agregar(@RequestBody @Valid dtoDetalle dto) {
        Detalle detalle = this.servicioDetalle.agregar(dto);
        return this.modelMapper.map(detalle, dtoDetalle.class);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(path = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public dtoDetalle actualizar(@PathVariable Integer id,@RequestBody @Valid dtoDetalle dto){
    Detalle detalle=this.servicioDetalle.actualizar(id, dto);
    return  this.modelMapper.map(detalle, dtoDetalle.class);
    }
}
