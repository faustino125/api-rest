/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest.modelo;


import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Setter @Getter
@Entity
@Table(name = "FACTURA")
public class Factura implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "FECHA", nullable = false, columnDefinition = "DATE")
    private LocalDate fecha;
    @ManyToOne
    @JoinColumn(name = "CLIENTE_ID",nullable = false)
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "PAGO_ID", nullable = false)
    private Pago pago;
}
