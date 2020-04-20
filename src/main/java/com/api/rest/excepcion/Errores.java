/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author FAUSTINO
 */
public class Errores extends ResponseStatusException {
   public  Errores(HttpStatus estadoHttp, String descripcion){
   super(estadoHttp, descripcion);
   }
   public Errores(HttpStatus estadoHttp, String descripcion, Throwable causa){
   super(estadoHttp, descripcion, causa);
   }
}
