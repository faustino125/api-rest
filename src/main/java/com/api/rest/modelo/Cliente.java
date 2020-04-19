/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.*;

/**
 *
 * @author FAUSTINO
 */
@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Setter @Getter
@Entity
@Table(name = "CLIENTE")
public class Cliente implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "NOMBRE", nullable = false, length = 32)
    private String nombre;
    @Column(name = "APELLIDO", nullable = false, length = 32)
    private String apellido;
    @Column(name = "DIRECCION", nullable = false, length = 32)
    private String direccion;
    @Column(name = "TELEFONO", nullable = false, length = 12)
    private String telefono;   
}
