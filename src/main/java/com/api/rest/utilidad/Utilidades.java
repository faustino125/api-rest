/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest.utilidad;

import com.api.rest.constante.General;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 *
 * @author FAUSTINO
 */
public class Utilidades {
    private Utilidades(){}
    public static String obtenerUbicacionRecurso(String recurso) {
        try {
            return URLDecoder.decode(Utilidades.class.getClassLoader().getResource(recurso).getPath(), General.UTF_8);
        } catch (UnsupportedEncodingException e) {
            return "Error al obtener el recurso";
        }

    }
    
}
