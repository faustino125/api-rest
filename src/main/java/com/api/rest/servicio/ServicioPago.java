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
import java.io.File;
import java.io.FileNotFoundException;
import net.sf.jasperreports.engine.JasperReport;
import org.springframework.http.HttpStatus;
import org.springframework.util.ResourceUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
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

    public Pago buscarPorId(Integer id) {
        return this.repositorioPago.findById(id).orElseThrow(() -> {
            String descripcion = String.format("No existe el id: ", id);
            return new Errores(HttpStatus.NOT_FOUND, descripcion);
        });
    }

    public Pago agregar(dtoPago dto) {
        Pago pago = new Pago();
        pago.setTipopago(dto.getTipopago());
        this.repositorioPago.save(pago);
        return pago;
    }

    public Pago actualizar(Integer id, dtoPago dto) {
        Pago pago = repositorioPago.findById(id).orElseThrow(() -> {
            String descripcion = String.format("No existe el id: ", id);
            return new Errores(HttpStatus.NOT_FOUND, descripcion);
        });
        pago.setTipopago(dto.getTipopago());
        this.repositorioPago.save(pago);
        return pago;
    }

    public void eliminar(Integer id) {
        Pago pago = repositorioPago.findById(id).orElseThrow(() -> {
            String descripcion = String.format("No existe el id: ", id);
            return new Errores(HttpStatus.OK, descripcion);
        });
        repositorioPago.delete(pago);
    }
    
    public String exportarTipoPagos(String extencion) throws FileNotFoundException, JRException{
    String path="C:\\Users\\Faustino\\Desktop";
    
    List<Pago> pago=repositorioPago.findAll();
    
    //cargar el archivo y compilarlo
    File ruta=ResourceUtils.getFile("classpath:jrxml/Pago.jrxml");
        JasperReport reporte=JasperCompileManager.compileReport(ruta.getAbsolutePath());
        JRBeanCollectionDataSource dataSource=new JRBeanCollectionDataSource(pago);
         
        Map<String, Object> parametro = new HashMap<>();
         
         parametro.put("createBy", "Faustino");
         
         JasperPrint imprimir=JasperFillManager.fillReport(reporte,parametro,dataSource);
         
         if(extencion.equalsIgnoreCase("html")){
         JasperExportManager.exportReportToHtmlFile(imprimir, path+"\\pago.html");
         }
         if(extencion.equalsIgnoreCase("pdf")){
         JasperExportManager.exportReportToPdfFile(imprimir,path+"\\pago.pdf");
         }
         return "Archivo exportado en la direccion: "+path;
    }
}
