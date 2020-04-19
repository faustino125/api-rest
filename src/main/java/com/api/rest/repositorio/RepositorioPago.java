/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest.repositorio;

import com.api.rest.modelo.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author FAUSTINO
 */
@Repository("repositorioPago")
public interface RepositorioPago extends JpaRepository<Pago, Integer>{
    
}
