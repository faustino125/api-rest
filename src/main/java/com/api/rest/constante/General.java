/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest.constante;

import java.math.BigDecimal;

/**
 *
 * @author FAUSTINO
 */
public final class General {
    
// Generales
    public static final String UTF_8 = "UTF-8";

    // Formatos de fechas
    public static final String FORMATO_FECHA_TIEMPO_1 = "yyyy/MM/dd HH:mm:ss";
    public static final String FORMATO_FECHA_TIEMPO_2 = "yyyyMMddHHmmss";
    public static final String FORMATO_FECHA_1 = "yyyy/MM/dd";
    public static final String FORMATO_FECHA_2 = "yyyyMMdd";
    public static final String FORMATO_HORA = "HH:mm:ss";


    public static final BigDecimal DIFF_PESO_PERMITIDO = new BigDecimal("1.05");

//______________________________________________________________________________
    /**
     * <p>Constructor privado, evita que la clase pueda ser instanciada.</p>
     */
    private General() {
    }
}
