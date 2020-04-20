/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest.dto;

import javax.persistence.Column;
import lombok.*;
/**
 *
 * @author FAUSTINO
 */
@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Setter @Getter
public class dtoCliente {
    private Integer id;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono; 
}
