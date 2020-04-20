/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.*;

/**
 *
 * @author FAUSTINO
 */
@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Setter @Getter
@Entity
@Table(name = "PAGO")
public class Pago implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;    
    @Column(name = "TIPOPAGO",nullable = false, length = 32)
    private String tipopago;
    
    @OneToMany(mappedBy = "pago")
    private List<Factura> factura;
}
