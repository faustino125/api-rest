/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest.constante;

import java.text.MessageFormat;

public enum EncabezadoHttp {
    
    ALLOW_ORIGIN            ("Access-Control-Allow-Origin", "*"),
    ALLOW_METHODS           ("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH"),
    ALLOW_HEADERS           ("Access-Control-Allow-Headers", "x-requested-with, access-control-allow-origin, authorization, accept, content-type, content-disposition, content-length"),
    CONTENT_DISPOSITION_PDF ("Content-Disposition", "attachment; filename={0}.pdf");
//______________________________________________________________________________
    /**
     * <p>Nombre del encabezado.</p>
     */
    private final String nombre;
//______________________________________________________________________________
    /**
     * <p>Valor del encabezado.</p>
     */
    private final String valor;
//______________________________________________________________________________
    /**
     * <p>Constructor privado, inicia los atributos de la enumeracion.</p>
     * 
     * @param nombre Nombre del encabezado
     * @param valor Valor del encabezado
     */
    private EncabezadoHttp(String nombre, String valor) {
        this.nombre = nombre;
        this.valor = valor;
    }
//______________________________________________________________________________
    /**
     * <p>Devuelve el nombre del encabezado http.</p>
     * 
     * @return Nombre del encabezado
     */
    public String nombre() {
        return this.nombre;
    }
//______________________________________________________________________________
    /**
     * <p>Devuelve el valor del encabezado http.</p>
     * 
     * @return Valor del encabezado
     */
    public String valor() {
        return this.valor;
    }
//______________________________________________________________________________
    /**
     * <p>Devuelve el valor del encabezado http.</p>
     * 
     * @param argumentos Listado de argumento para el formato del valor
     * @return Valor del encabezado
     */
    public String valor(Object... argumentos) {
        return MessageFormat.format(this.valor, argumentos);
    }
}
