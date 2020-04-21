package com.api.rest.rest;

import com.api.rest.dto.dtoCategoria;
import com.api.rest.modelo.Categoria;
import com.api.rest.servicio.ServicioCategoria;

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

@RestController
@RequestMapping("/categoria")
public class RestCategoria {

    @Resource
    private ModelMapper modelMapper;
    @Resource
    private ServicioCategoria servicioCategoria;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<dtoCategoria> mostrar() {
        return this.servicioCategoria.mostarCategoria()
                .stream()
                .map(categoria -> this.modelMapper.map(categoria, dtoCategoria.class))
                .collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public dtoCategoria buscar(@PathVariable Integer id) {
        Categoria categoria = this.servicioCategoria.buscarPorId(id);
        return this.modelMapper.map(categoria, dtoCategoria.class);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public dtoCategoria agregar(@RequestBody @Valid dtoCategoria dto) {
        Categoria categoria = this.servicioCategoria.agregar(dto);
        return this.modelMapper.map(categoria, dtoCategoria.class);
    }
}
