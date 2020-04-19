/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.rest.repositorio;

import com.api.rest.modelo.Categoria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("repositorioCategoria")
public interface RepositorioCategoria extends JpaRepository<Categoria, Integer>{
}
