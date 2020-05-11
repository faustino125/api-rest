/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest.dto;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author FAUSTINO
 */
public abstract class DtoPagos {
    
    @FunctionalInterface
    private interface Pagos{
        String getPagos();
    }
    
 
    @Getter
    @Setter
    public static class Response implements  Pagos{
    private String pagos;
    }
}
