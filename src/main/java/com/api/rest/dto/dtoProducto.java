/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest.dto;

import lombok.*;

/**
 *
 * @author FAUSTINO
 */
@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Setter @Getter
public class dtoProducto {
    private Integer id;
    private String nombre;
    private float precio;
    private Integer cantidad;
    private Integer categoria;
}
