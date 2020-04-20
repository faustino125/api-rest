/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest.servicio;

import com.api.rest.modelo.Pago;
import com.api.rest.repositorio.RepositorioPago;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author FAUSTINO
 */
@Service("servicioPago")
public class ServicioPago {
    @Resource
    private RepositorioPago repositorioPago;
    
    public List<Pago> mostrarPago(){
    return this.repositorioPago.findAll();
    }
}
