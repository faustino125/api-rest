/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest.servicio;

import com.api.rest.modelo.Pago;
import com.api.rest.repositorio.RepositorioPago;
import com.api.rest.utilidad.Utilidades;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

/**
 *
 * @author FAUSTINO
 */
@Service("servicioReporte")
public class ServicoReporte {

    @Resource
    private RepositorioPago repositorioPago;
    private static String JASPER_PAGO;

    static {
        try {
            String ruta = Utilidades.obtenerUbicacionRecurso("jrxml/Pago.jrxml");
            JasperCompileManager.compileReportToFile(ruta);
            JASPER_PAGO = ruta.replace(".jrxml", ".jasper");
        } catch (Exception e) {
        }
    }

    public byte[] exportarPagoPDF() throws FileNotFoundException, JRException {
        List<Pago> pago = repositorioPago.findAll();
        String imprimirArchivo = null;
        JRBeanCollectionDataSource datos = new JRBeanCollectionDataSource(pago);
        Map parameters = new HashMap();
        try {
            imprimirArchivo = JasperFillManager.fillReportToFile(JASPER_PAGO, parameters, datos);
            if (imprimirArchivo != null) {
                JasperExportManager.exportReportToPdfFile(imprimirArchivo,
                        "C://Users//FAUSTINO//Desktop//Pago.pdf");
            }
        } catch (Exception e) {
        }
        return null;
    }
       
}
