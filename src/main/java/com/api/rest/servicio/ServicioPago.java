/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest.servicio;

import com.api.rest.dto.dtoPago;
import com.api.rest.excepcion.Errores;
import com.api.rest.modelo.Pago;
import com.api.rest.repositorio.RepositorioPago;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 *
 * @author FAUSTINO
 */
@Service("servicioPago")
public class ServicioPago {

    @Resource
    private RepositorioPago repositorioPago;

    public List<Pago> mostrarPago() {
        return this.repositorioPago.findAll();
    }

    public Pago buscarPOrId(Integer id) {
        return this.repositorioPago.findById(id).orElseThrow(() -> {
            String descripcion = String.format("No existe el id: ", id);
            return new Errores(HttpStatus.NOT_FOUND, descripcion);
        });
    }

    public Pago agregar(dtoPago dto){
     Pago pago=new Pago();
     pago.setTipopago(dto.getTipopago());
     this.repositorioPago.save(pago);
     return pago;
    }
}
