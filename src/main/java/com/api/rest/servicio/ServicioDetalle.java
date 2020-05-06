/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest.servicio;

import com.api.rest.dto.dtoDetalle;
import com.api.rest.excepcion.Errores;
import com.api.rest.modelo.Detalle;
import com.api.rest.modelo.Factura;
import com.api.rest.modelo.Producto;
import com.api.rest.repositorio.RepositorioDetalle;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 *
 * @author FAUSTINO
 */
@Service("servicioDetalle")
public class ServicioDetalle {

    @Resource
    private RepositorioDetalle repositorioDetalle;
    @Resource
    private ServicioFactura servicioFactura;
    @Resource
    private ServicioProducto servicioProducto;

    public List<Detalle> mostrarDetalle() {
        return this.repositorioDetalle.findAll();
    }

    public Detalle buscarPorId(Integer id) {
        return this.repositorioDetalle.findById(id).orElseThrow(() -> {
            String descripcion = String.format("No existe id: ", id);
            return new Errores(HttpStatus.NOT_FOUND, descripcion);
        });
    }

    public Detalle agregar(dtoDetalle dto) {
        Factura factura = this.servicioFactura.buscarPorId(dto.getFacturaId());
        Producto producto = this.servicioProducto.buscarPorId(dto.getProductoId());
        Detalle detalle = new Detalle();
        detalle.setCantidad(dto.getCantidad());
        detalle.setPrecio(dto.getPrecio());
        detalle.setProducto(producto);
        detalle.setFactura(factura);
        this.repositorioDetalle.save(detalle);
        return detalle;
    }

    public Detalle actualizar(Integer id, dtoDetalle dto) {
        Factura factura = this.servicioFactura.buscarPorId(dto.getFacturaId());
        Producto producto = this.servicioProducto.buscarPorId(dto.getProductoId());
        Detalle detalle = repositorioDetalle.findById(id).orElseThrow(() -> {
            String descripcion = String.format("No existe el id: ", id);
            return new Errores(HttpStatus.NOT_FOUND, descripcion);
        });
        detalle.setCantidad(dto.getCantidad());
        detalle.setPrecio(dto.getPrecio());
        detalle.setProducto(producto);
        detalle.setFactura(factura);
        this.repositorioDetalle.save(detalle);
        return detalle;
    }
}
