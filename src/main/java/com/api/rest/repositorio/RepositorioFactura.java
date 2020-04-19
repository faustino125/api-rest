/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest.repositorio;

import com.api.rest.modelo.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author FAUSTINO
 */
@Repository("repositorioFactura")
public interface RepositorioFactura extends JpaRepository<Factura, Integer>{
    
}
