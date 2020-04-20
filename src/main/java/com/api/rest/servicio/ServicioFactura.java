/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest.servicio;

import com.api.rest.excepcion.Errores;
import com.api.rest.modelo.Factura;
import com.api.rest.repositorio.RepositorioFactura;
import java.util.List;
import javax.annotation.Resource;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 *
 * @author FAUSTINO
 */
@Service("servicioFactura")
public class ServicioFactura {

    @Resource
    private RepositorioFactura repositorioFactura;

    public List<Factura> mostrarFactura() {
        return this.repositorioFactura.findAll();
    }

    public Factura buscarPorId(Integer id) {
        return this.repositorioFactura.findById(id).orElseThrow(() -> {
            String descripcion = String.format("No existe el id: ", id);
            return new Errores(HttpStatus.NOT_FOUND, descripcion);
        });
    }
}
