/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest.configuracion;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author FAUSTINO
 */
@Configuration
public class Configuracion {
        @Bean("modelMapper")
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
