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
public class Carrera {
    
    public Carrera(int idCarrera, String nombreCarrera, String detalleCarrera){
        this.idCarrera = idCarrera;
        this.nombreCarrera = nombreCarrera;
        this.detalleCarrera = detalleCarrera;
    }

    public Carrera() {
    }
    
    
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int idCarrera;
    
    @NotNull (message = "Campo obligatorio")
    private String nombreCarrera;
    
    @NotNull (message = "Campo obligatorio")
    private String detalleCarrera;

    public int getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public String getDetalleCarrera() {
        return detalleCarrera;
    }

    public void setDetalleCarrera(String detalleCarrera) {
        this.detalleCarrera = detalleCarrera;
    }
    
    
}
