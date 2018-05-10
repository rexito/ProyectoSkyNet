/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SkyNet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *
 * @author don_w
 */

@Entity
public class Jornada {
    
    public Jornada(int idJornada, String detalleJornada){
        this.idJornada = idJornada;
        this.detalleJornada = detalleJornada;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idJornada;
    
    @NotNull (message = "Campo Obligatorio")
    private String nombreJornada;
    
    @NotNull (message = "Campo Obligatorio")
    private String detalleJornada;

    public int getIdJornada() {
        return idJornada;
    }

    public void setIdJornada(int idJornada) {
        this.idJornada = idJornada;
    }

    public String getDetalleJornada() {
        return detalleJornada;
    }

    public void setDetalleJornada(String detalleJornada) {
        this.detalleJornada = detalleJornada;
    }
    
    
    }
