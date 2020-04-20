/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest.servicio;

import com.api.rest.modelo.Factura;
import com.api.rest.repositorio.RepositorioFactura;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author FAUSTINO
 */
@Service("servicioFactura")
public class ServicioFactura {

    @Resource
    private RepositorioFactura repositorioFactura;

    public List<Factura> mostarFactura() {
        return this.repositorioFactura.findAll();
    }
}
