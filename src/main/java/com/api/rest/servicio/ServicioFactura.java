/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest.servicio;

import com.api.rest.dto.dtoFactura;
import com.api.rest.excepcion.Errores;
import com.api.rest.modelo.Cliente;
import com.api.rest.modelo.Factura;
import com.api.rest.modelo.Pago;
import com.api.rest.repositorio.RepositorioFactura;
import java.util.List;
import javax.annotation.Resource;
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
    @Resource
    private ServicioPago servicioPago;
    @Resource
    private ServicioCliente servicioCliente;
            
            
    public List<Factura> mostrarFactura() {
        return this.repositorioFactura.findAll();
    }

    public Factura buscarPorId(Integer id) {
        return this.repositorioFactura.findById(id).orElseThrow(() -> {
            String descripcion = String.format("No existe el id: ", id);
            return new Errores(HttpStatus.NOT_FOUND, descripcion);
        });
    }

    public Factura agregar(dtoFactura dto){
        Cliente cliente=this.servicioCliente.buscarPorId(dto.getClienteId());
        Pago pago = this.servicioPago.buscarPOrId(dto.getPagoId());
        Factura factura=new Factura();
        factura.setFecha(dto.getFecha());
        factura.setCliente(cliente);
        factura.setPago(pago);
        this.repositorioFactura.save(factura);
        return factura;
    }
        
}
