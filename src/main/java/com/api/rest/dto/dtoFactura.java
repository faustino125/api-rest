/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest.dto;

import java.time.LocalDate;
import lombok.*;

/**
 *
 * @author FAUSTINO
 */
@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Setter @Getter
public class dtoFactura {
    private Integer id;
    private LocalDate fecha;
    private Integer cliente;
    private Integer pago;
}
