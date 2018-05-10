/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SkyNet.repository;

import com.SkyNet.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author don_w
 */
public interface AdministradorRepository extends JpaRepository<Administrador, Integer> {

    public Administrador findOne(Integer id);
    
}
