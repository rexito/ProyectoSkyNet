/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SkyNet.repository;

import com.SkyNet.model.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author don_w
 */
public interface CarreraRepository extends JpaRepository<Carrera, Integer>{
    
}
